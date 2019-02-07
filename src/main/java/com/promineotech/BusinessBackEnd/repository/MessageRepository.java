package com.promineotech.BusinessBackEnd.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.BusinessBackEnd.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

	Iterable<Message> getMessagesByClientId(Long clientId);
	
}
