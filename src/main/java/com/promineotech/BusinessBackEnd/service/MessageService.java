package com.promineotech.BusinessBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.*;
import com.promineotech.BusinessBackEnd.repository.*;

@Service
public class MessageService {

	@Autowired
	private MessageRepository mrepo;
	
	@Autowired
	private ClientRepository crepo;
	
	@Autowired
	private AuthService authService;
	
	
	// get request to test HttpServletRequest
	public String getRequest() {
		return authService.getJwt();
	}
	
	// return all messages
	public Iterable<Message> displayMessage() {
		// get user from jwt
		String jwt = authService.getJwt();
		Client user = crepo.findByUsername(authService.getUserNameFromJwtToken(jwt));
		
		// validate user
		if (user != null && user.getRole().equals("ROLE_ADMIN")) {
			return mrepo.findAll();
		}
		return null;
	}
	
	// return all messages by client id
	public Iterable<Message> getMessageByClientId(Long id) {
		
		// get user from id
		Client client = crepo.findById(id).orElse(null);
		
		// get user from jwt
		String jwt = authService.getJwt();
		Client user = crepo.findByUsername(authService.getUserNameFromJwtToken(jwt));
		
		// validate user
		if (authService.validateJwtToken(jwt, client.getUsername()) 
				|| (user.getRole().equals("ROLE_ADMIN"))) {
			// return messages if client is valid
			return mrepo.getMessagesByClientId(id);
		} else {
			// should actually throw exception
			System.out.println("null returned, uh oh! =====================");
			return null;
		}
		
	}
	
	// delete message by message id
	public void deleteMessage(Long id) {
		mrepo.deleteById(id);
	}
	
	// create a new message with client id
	public Message createMessage(Long clientId, Message message) {
		
		// get jwt
		String jwt = authService.getJwt();
		
		Client user = crepo.findByUsername(authService.getUserNameFromJwtToken(jwt));
		Client client = crepo.findById(clientId).orElse(null);
		
		if (client != null && (authService.validateJwtToken(jwt, client.getUsername())
				|| user.getRole().equals("ROLE_ADMIN"))) {
			message.setClient(client);
	
			// Set user that sent message
			if (user.getRole().equals("ROLE_ADMIN")) {
				message.setUsername(user.getUsername());
			} else {
				message.setUsername(client.getUsername());
			}
			
			return mrepo.save(message);
		}
		// return exception
		return null;
		
	}
}
