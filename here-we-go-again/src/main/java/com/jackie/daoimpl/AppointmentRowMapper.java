package com.jackie.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jackie.domain.Appointment;

public class AppointmentRowMapper implements RowMapper<Appointment>
{
	public Appointment mapRow(ResultSet resultSet, int arg1) throws SQLException 
	{
		Appointment appointment = new Appointment();
		appointment.setId(resultSet.getInt("id"));
		appointment.setClientID(resultSet.getInt("client_id"));
		appointment.setPetID(resultSet.getInt("pet_id"));
		appointment.setDate(resultSet.getDate("date"));
		appointment.setTime(resultSet.getDouble("time"));
		return appointment;
	}

}
