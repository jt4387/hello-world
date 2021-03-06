package com.jackie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jackie.domain.Appointment;
import com.jackie.service.AppointmentService;

@RequestMapping(value="/appointmentHome")
@Controller
public class AppointmentController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService appointmentService;
	
	// Page Not Found
	@RequestMapping(value="*")
	public String pageNotFound()
	{
		return "pageNotFound";
	}
	
	
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
