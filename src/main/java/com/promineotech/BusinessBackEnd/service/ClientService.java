package com.promineotech.BusinessBackEnd.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repo;
	
	public Client getClient(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Iterable<Client> getClients() {
		return repo.findAll();
	}
	
	public void deleteClient(Long id) {
		repo.deleteById(id);
	}
	
	public Client updateClient(Long id, Client client) {
		Client foundClient = repo.findById(id).orElse(null);
		if (foundClient != null) {
			foundClient.setFirstName(client.getFirstName());
			foundClient.setLastName(client.getLastName());
			foundClient.setPhone(client.getPhone());
			foundClient.setEmail(client.getEmail());
			foundClient.setDob(client.getDob());
			repo.save(foundClient);
		}
		return foundClient;
	}
	
	public Client createClient(Client client) {
		return repo.save(client);
	}
	
	public static LocalDate formatDob(String dob) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dobFormatted;
		try {
			dobFormatted = LocalDate.parse(dob, dtf);
		} catch (DateTimeParseException ex) {
			dobFormatted = LocalDate.of(1900, 01, 01);
		}
		return dobFormatted;
	}
}
