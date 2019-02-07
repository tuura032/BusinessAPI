package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.BusinessBackEnd.entity.Message;
import com.promineotech.BusinessBackEnd.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService service;
	
	// get all messages
	@RequestMapping("/messages")
	public Iterable<Message> getAllMessages() {
		return service.displayMessage();
	}
	
	// GET messages by client id
	@RequestMapping("/client/{clientId}/messages")
	public Iterable<Message> displayMessage(@PathVariable Long clientId) {
		return service.getMessageByClientId(clientId);
	}
	
	// GET single message
	@RequestMapping("/messages/{messageId}")
	public Message singleMessage(@PathVariable Long messageId) {
		return service.getMessageById(messageId);
	}
	
	// Create new messagse POST
	@RequestMapping(value="/client/{clientId}/messages", method=RequestMethod.POST)
	public Message newMessage(@PathVariable Long clientId, 
			@RequestBody Message message) {

		return service.createMessage(clientId, message);
	}
	
	// Delete a Message with message id
	@RequestMapping(value="/client/{customerId}/messages/{messageId}", method=RequestMethod.DELETE)
	public void deleteMessageByMessageId(@PathVariable long messageId) {
		service.deleteMessage(messageId);
	}

	
}