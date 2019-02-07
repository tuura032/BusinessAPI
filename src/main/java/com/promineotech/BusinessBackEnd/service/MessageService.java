package com.promineotech.BusinessBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.*;
import com.promineotech.BusinessBackEnd.repository.*;

@Service
public class MessageService {

	@Autowired
	MessageRepository mrepo;
	
	@Autowired
	ClientRepository crepo;
	
	
	// return all messages
	public Iterable<Message> displayMessage() {
		return mrepo.findAll();
	}
	
	// return all messages by client id
	public Iterable<Message> getMessageByClientId(Long id) {
		
		return mrepo.getMessagesByClientId(id);
	}
	
	// return single message by message id
	public Message getMessageById(Long id) {
		return mrepo.findById(id).orElse(null);
	}
	
	// delete message by message id
	public void deleteMessage(Long id) {
		mrepo.deleteById(id);
	}
	
	// create a new message with client id
	public Message createMessage(Long clientId, Message message) {
		Client foundClient = crepo.findById(clientId).orElse(null);
		if (foundClient != null) {
			message.setClient(foundClient);
		}
		return mrepo.save(message);
	}
}
