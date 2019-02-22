package com.promineotech.BusinessBackEnd.service;

import java.security.Key;
import java.util.Base64;


import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.entity.LoginCredentials;
import com.promineotech.BusinessBackEnd.entity.RegisterUser;
import com.promineotech.BusinessBackEnd.repository.ClientRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	private String encodedKey;
	
	public Client register(RegisterUser newUser) throws AuthenticationException {
		Client client = new Client();
		client.setUsername(newUser.getUsername());
		client.setHash((BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt())));
		client.setEmail(newUser.getEmail());
		client.setFirstName(newUser.getFirstName());
		client.setLastName(newUser.getLastName());
		client.setPhone(newUser.getPhone());
		client.setDob(ClientService.formatDob(newUser.getDob()));
		client.setRole("ROLE_USER");
	
		try {
			clientRepository.save(client);
			return client;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available.");
		}
	}
	
	public Client login(LoginCredentials cred) throws AuthenticationException {
		Client foundClient = clientRepository.findByUsername(cred.getUsername());
		if (foundClient != null && BCrypt.checkpw(cred.getPassword(), foundClient.getHash())) {
			return foundClient;
		}
		throw new AuthenticationException("Incorrect username or password.");
	}
	
	
	public String generateJwtToken(Client client) {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
		
		return Jwts.builder()
				.setSubject(client.getUsername())
				.signWith(key)
				.compact();
	}
	
	public boolean validateJwtToken(String jwt, String username) {
		
		//decoded key
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		
		// check for user and user role
		if (Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(jwt).getBody().getSubject().equals(username)) {
			System.out.println("auth service about to return true");
			return true;
		} else {
			System.out.println("auth service about to return false");
			return false;
		}
	}
	
	public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(Base64.getDecoder().decode(encodedKey))
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
	
	public String getJwt(HttpHeaders header) {
        String authHeader = header.getFirst("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	return authHeader.replace("Bearer ","");
        }

        return null;
    }
	
	public String getJwt() {
		String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	return authHeader.replace("Bearer ","");
        }
        return null;
    }
	

}
