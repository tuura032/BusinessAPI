package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.service.ClientService;


@RestController
public class ClientController {

	//private static final Logger logger = LogManager.getLogger(ClientController.class);
	
	@Autowired
	ClientService service;
	
	// get information from a client
	@RequestMapping(value="/client/{id}")
	public Client getClient(@PathVariable Long id) {
		return service.getClient(id);
	}
	
	// Admin creates new client.
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		return service.createClient(client);
	}
	
	// Delete a client
	@RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable Long id) {
		service.deleteClient(id);
	}
	
	// Admin gets list of all clients
	@RequestMapping(value="/client")
	public Iterable<Client> getAllClients() {
		return service.getClients();
	}
	
	// update client information
	@RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
	public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
		return service.updateClient(id, updatedClient);
	}
}
