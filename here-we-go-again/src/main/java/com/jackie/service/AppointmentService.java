package com.jackie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackie.dao.AppointmentDao;
import com.jackie.domain.Appointment;

@Service
public class AppointmentService 
{
	@Autowired
	private AppointmentDao appointmentDao;
	
	// Get All Appointments
	public List<Appointment> getFullAppointmentList()
	{
		List<Appointment> appointments = appointmentDao.getAllAppointments();
		return appointments;
	}
}
