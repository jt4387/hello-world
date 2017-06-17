package com.jackie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackie.domain.DogWalkerClient;
import com.jackie.service.ClientService;

@Controller
public class ClientController 
{
	@Autowired
	private ClientService clientService;
	
	// Go to client page
	@RequestMapping("/client")
	public String clientPageTag()
	{
		return "mainClientPage";
	}
	
	// List clients
	@RequestMapping("/getClientList")
	public String listClients(Model model)
	{
		List<DogWalkerClient> clients = clientService.getClientList();
		model.addAttribute("allClients", clients);
		return "clientList";
	}
	
	// Go to add client form page
	@RequestMapping("/addClientForm")
	public String goToAddClientForm()
	{
		return "addNewClient";
	}
	
	// Add a client form
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String addClient(@RequestParam("firstName") String firstName, @RequestParam("lastName")
			String lastName, @RequestParam("address") String address)
	{
		DogWalkerClient dwc = new DogWalkerClient(firstName, lastName, address);
		clientService.addClientToList(dwc);
		return "mainClientPage";
	}
	
	// Go to add pet page
	@RequestMapping(value = "/addPetForm")
	public String goToAddPetForm()
	{
		return "addNewPet";
	}
	
	// Add a pet
	@RequestMapping(value = "/addPet", method = RequestMethod.GET)
	public String addPet(@RequestParam("clientID") int clientID, @RequestParam("petName")
			String petName)
	{
		clientService.addPetToClient(clientID, petName);
		return "mainClientPage";
	}
	
}
