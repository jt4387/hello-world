package com.jackie.daoimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jackie.dao.AppointmentDao;
import com.jackie.domain.Appointment;

@Repository
public class AppointmentDaoImpl implements AppointmentDao
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	/**
	 * Create an appointment record
	 */
	public boolean createAppointment(Appointment appointment) 
	{
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(appointment);
		String sqlQuery = "INSERT INTO appointments (client_id, pet_id, date, time) VALUES("
				+ ":clientID, :petID, :date, :time";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}
	
	/**
	 * Get all the appointments for a particular client
	 */
	public List<Appointment> getClientAppointments(Integer clientID) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource("ID", clientID);
		String sqlQuery = "SELECT client_id, pet_id, date, time FROM appointments WHERE client_id = :ID";
		List<Appointment> appointments = namedParameterJdbcTemplate.query(sqlQuery, new AppointmentRowMapper());
		return appointments;
	}

	public List<Appointment> getPetAppointments(Integer clientID, Integer petID) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("CID", clientID);
		params.addValue("PID", petID);
		String sqlQuery = "SELECT client_id, pet_id, date, time FROM appointments WHERE client_id = :CID AND"
				+ "petID = :pid";
		List<Appointment> appointments = namedParameterJdbcTemplate.query(sqlQuery, new AppointmentRowMapper());
		return appointments;
	}

	public List<Appointment> getDailyAppointments(Date date) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource("date", date);
		String sqlQuery = "SELECT client_id, pet_id, date, time FROM appointments WHERE date = :date";
		List<Appointment> appointments = namedParameterJdbcTemplate.query(sqlQuery, new AppointmentRowMapper());
		return appointments;
	}

	public List<Appointment> getAllAppointments() 
	{
		String sqlQuery = "SELECT * FROM appointments";
		List<Appointment> appointments = namedParameterJdbcTemplate.query(sqlQuery, new AppointmentRowMapper());
		return appointments;
	}

	public boolean delete(Integer id) 
	{
		MapSqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "DELETE FROM appointments WHERE id = :ID";
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}

	public boolean updateDateTime(Appointment appointment, Date date, double time) 
	{
		SqlParameterSource params = new BeanPropertySqlParameterSource(appointment);
		String sqlQuery = "UPDATE appointments SET date = :date, time = :time WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}

	public void cleanup() 
	{
		String sqlQuery = "TRUNCATE table appointments";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}
}
