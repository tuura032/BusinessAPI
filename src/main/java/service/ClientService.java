package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Client;
import repository.ClientRepository;

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
	
	public Client updateClient(long id, Client client) {
		Client foundClient = repo.findById(id).orElse(null);
		if (foundClient != null) {
			foundClient.setFirstName(client.getFirstName());
			foundClient.setLastName(client.getLastName());
			foundClient.setPhone(client.getPhone());
			foundClient.setEmail(client.getEmail());
			foundClient.setDOB(client.getDOB());
			repo.save(foundClient);
		}
		return foundClient;
	}
	
	public Client createClient(Client client) {
		return repo.save(client);
	}
}
