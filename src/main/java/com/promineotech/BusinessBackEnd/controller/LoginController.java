package com.promineotech.BusinessBackEnd.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.BusinessBackEnd.entity.LoginCredentials;
import com.promineotech.BusinessBackEnd.entity.RegisterUser;
import com.promineotech.BusinessBackEnd.service.AuthService;

@RestController
@RequestMapping("/users")
public class LoginController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody RegisterUser newUser) {
		try {
			return new ResponseEntity<Object>(authService.register(newUser), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody LoginCredentials cred) {
		try {
			return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
}
