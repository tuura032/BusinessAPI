package com.promineotech.BusinessBackEnd.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.entity.LoginCredentials;
import com.promineotech.BusinessBackEnd.entity.RegisterUser;
import com.promineotech.BusinessBackEnd.service.AuthService;

@RestController
@RequestMapping("/users")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody RegisterUser newUser) {
		try {
			
			// It's unclear why I need to return the user.
			return new ResponseEntity<Object>(authService.register(newUser), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginCredentials cred) {
		try {
			Client client = authService.login(cred);
			if (client != null) {
				String jwt = authService.generateJwtToken(client);
				return ResponseEntity.ok(jwt);
			}
			
			//return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return null;
	}
}
