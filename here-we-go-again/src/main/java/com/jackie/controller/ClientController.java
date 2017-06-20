package com.jackie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackie.domain.DogWalkerClient;
import com.jackie.service.ClientService;

@RequestMapping(value="/clientHome")
@Controller
public class ClientController 
{
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	// Page Not Found
	@RequestMapping(value="*")
	public String pageNotFound()
	{
		return "pageNotFound";
	}
	
	// Go to home
	@RequestMapping(value="/home")
	public String goHome()
	{
		return "home";
	}
	
	// Go to client page
	@RequestMapping("/client")
	public String clientPageTag()
	{
		//LOGGER.info("Going to the mainClientPage!");
		return "mainClientPage";
	}
	
	// List clients
	@RequestMapping("/getClientList")
	public String listClients(Model model)
	{
		//LOGGER.info("In the listClients method!");
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
	@RequestMapping(value = "/addClient")
	public String addClient(@RequestParam String firstName, @RequestParam String lastName, 
			@RequestParam String address)
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
	@RequestMapping(value = "/addPet")
	public String addPet(@RequestParam int clientID, @RequestParam String petName)
	{
		clientService.addPetToClient(clientID, petName);
		return "mainClientPage";
	}
	
}
