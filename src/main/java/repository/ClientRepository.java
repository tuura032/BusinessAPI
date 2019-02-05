package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

	
}
