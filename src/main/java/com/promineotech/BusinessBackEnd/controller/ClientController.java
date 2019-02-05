package com.promineotech.BusinessBackEnd.controller;

import service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Client;

@RestController
public class ClientController {

	@Autowired
	ClientService cs;
	
	// get information from a client
	@RequestMapping(value="/client/{id}")
	public Client getClient(@PathVariable long id) {
		return cs.getClient(id);
	}
	
	// create new client. Might delete this? Or keep it?
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		return cs.createClient(client);
	}
	
	// Delete a client
	@RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable long id) {
		cs.deleteClient(id);
	}
	
	// Admin gets list of all clients
	@RequestMapping(value="/client")
	public Iterable<Client> getAllClients() {
		return cs.getClients();
	}
	
	// update client information
	@RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
	public Client updateClient(@PathVariable long id, @RequestBody Client updatedClient) {
		return cs.updateClient(id, updatedClient);
	}
}
