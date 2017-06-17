package com.jackie.dao;

import java.util.List;

import javax.sql.DataSource;

import com.jackie.domain.DogWalkerClient;

public interface ClientDao 
{
	// Set the data source
	public void setDataSource(DataSource ds);
	
	// Create a record in the client_list table
	public boolean createClient(DogWalkerClient dwc);
	
	// Create a record in the pets table
	// Connected to client_list by clientID
	public boolean createPet(Integer clientID, String petName);
	
	// Retrieve a single client
	public DogWalkerClient getClient(Integer id);
	
	// Retrieve a single pet
	public String getPet(Integer id);
	
	// Retrieve all clients
	public List<DogWalkerClient> getAllClients();
	
	// Retrieve all pets
	public List<String> getAllPets();
	
	// Retrieve all pets belonging to a client using the clientID
	public List<String> getAllClientPets(Integer clientID);
	
	// Delete a client from the table
	// Delete the client's pet from the pet table
	// TODO do we need the clientID can we just get the clientID from the dwc object????
	public boolean deleteClient(DogWalkerClient dwc, Integer clientID);
	
	// Delete a pet from the table
	public boolean deletePet(Integer id);
	
	// Update an existing client
	public boolean updateClient(DogWalkerClient dwc);
	
	// Update an existing pet
	public boolean updatePet(Integer id, String petName);
	
	public void cleanup();
}
