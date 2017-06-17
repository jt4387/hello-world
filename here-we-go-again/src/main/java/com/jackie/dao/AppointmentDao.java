package com.jackie.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import com.jackie.domain.Appointment;

public interface AppointmentDao 
{
	// Set the data source
	public void setDataSource(DataSource dataSource);
	
	// Create a record in the appointments table
	public boolean createAppointment(Appointment appointment);
	
	// Retrieve all appointments for a client
	public List<Appointment> getClientAppointments(Integer clientID);
	
	// Retrieve all appointments for a pet belonging to a client
	public List<Appointment> getPetAppointments(Integer clientID, Integer petID);
	
	// Retrieve all appointments for the day
	public List<Appointment> getDailyAppointments(Date date);
	
	// Retrieve all appointments
	public List<Appointment> getAllAppointments();
	
	// Delete an appointment
	public boolean delete(Integer id);
	
	// Update the date of an appointment
	public boolean updateDateTime(Appointment appointment, Date date, double time);
	
	public void cleanup();
	
	
}
