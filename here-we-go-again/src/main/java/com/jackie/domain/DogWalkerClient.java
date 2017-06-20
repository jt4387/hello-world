package com.jackie.domain;

import java.util.ArrayList;
import java.util.List;

public class DogWalkerClient 
{
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private List<String> pets;
	
	// For database purposes
	public DogWalkerClient()
	{
		this.pets = new ArrayList<>();
	}
	
	public DogWalkerClient(String firstName, String lastName, String address) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.pets = new ArrayList<>();
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public void addPet(String petName) 
	{
		pets.add(petName);
	}

	public int getId() 
	{
		return id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public String getAddress() 
	{
		return address;
	}

	public List<String> getPets() 
	{
		return pets;
	}
	
	public void addPets(List<String> petNames)
	{
		for (String petName : petNames)
		{
			pets.add(petName);
		}
	}


	
}
