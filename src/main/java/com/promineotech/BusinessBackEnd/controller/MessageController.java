package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Message;
import service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService service;
	
	// GET all messages
	@RequestMapping("/messages")
	public Iterable<Message> displayMessage() {
		return service.displayMessage();
	}
	
	// Create new messagse POST
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public Message newMessage(@RequestBody Message message) {
		return service.createMessage(message);
	}
	
	// Delete a Message with message id
	@RequestMapping(value="/messages/{id}", method=RequestMethod.DELETE)
	public void deleteMessageByMessageId(@PathVariable long id) {
		service.deleteMessage(id);
	}

	
}