package com.jackie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jackie.domain.Appointment;
import com.jackie.service.AppointmentService;

@Controller
public class AppointmentController 
{
	@Autowired
	private AppointmentService appointmentService;
	
	// Go to appointment page
	@RequestMapping("/schedule")
	public String schedulePage()
	{
		return "mainSchedulePage";
	}
	
	// Get all appointments
	@RequestMapping("/getAllAppointments")
	public String listAllAppointments(Model model)
	{
		List<Appointment> appointments = appointmentService.getFullAppointmentList();
		model.addAttribute("allAppointments", appointments);
		return "appointmentList";
	}

}
