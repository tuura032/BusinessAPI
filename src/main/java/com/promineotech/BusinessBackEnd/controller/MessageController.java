package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	/*
	 * test methods
	 */
	
	// get header information from @RequestHeader
	@RequestMapping(value="/header")
	public String showHeader(@RequestHeader HttpHeaders header) {
		return header.getFirst("Authorization");
	}
	
	// get header information from HttpServletRequest
	@RequestMapping(value="/request")
	public String getAuthorization() {
		return service.getRequest();
	}
	
}