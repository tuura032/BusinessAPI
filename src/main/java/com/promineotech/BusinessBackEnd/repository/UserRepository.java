package com.promineotech.BusinessBackEnd.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.BusinessBackEnd.entity.Client;

public interface UserRepository extends CrudRepository<Client, Long>{

	public Client findByUsername(String username);
}
