package com.jackie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackie.dao.ClientDao;
import com.jackie.domain.DogWalkerClient;

@Service
public class ClientService 
{
	@Autowired
	private ClientDao clientDao;
	
	// Get Full Client List
	public List<DogWalkerClient> getClientList()
	{
		List<DogWalkerClient> clientList = clientDao.getAllClients();
		return clientList;
	}
	
	// Get Full Pet List
	public List<String> getPetList()
	{
		List<String> petList = clientDao.getAllPets();
		return petList;
	}
	
	public void addClientToList(DogWalkerClient dwc)
	{
		clientDao.createClient(dwc);
	}
	
	public void addPetToClient(int clientID, String petName)
	{
		clientDao.createPet(clientID, petName);
	}
	
	
	
}
