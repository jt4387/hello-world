package com.jackie.domain;

import java.sql.Date;
import java.time.LocalDateTime;

public class Appointment 
{
	private int id;
	private int clientID;
	private int petID;
	private Date date;
	private double time;
	
	// for database
	public Appointment()
	{
		
	}
	
	public Appointment(int clientID, int petID, Date date, double time)
	{
		this.clientID = clientID;
		this.petID = petID;
		this.date = date;
		this.time = time;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getClientID() 
	{
		return clientID;
	}

	public void setClientID(int clientID) 
	{
		this.clientID = clientID;
	}

	public int getPetID() 
	{
		return petID;
	}

	public void setPetID(int petID) 
	{
		this.petID = petID;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public double getTime() 
	{
		return time;
	}

	public void setTime(double time) 
	{
		this.time = time;
	}
	
	
}
