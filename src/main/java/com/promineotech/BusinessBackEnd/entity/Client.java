package com.promineotech.BusinessBackEnd.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client {

	private Long id;
	private String username;
	private String hash;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	// also height, wt, address, payment, etc
	
	public Client() {
		
	}
	
	public Client(String firstName, String lastName, String email, String phone, String dob) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setDob(dob);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long clientId) {
		this.id = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob.toString();
	}

	public void setDob(String dob) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dobFormatted;
		try {
			dobFormatted = LocalDate.parse(dob, dtf);
		} catch (DateTimeParseException ex) {
			dobFormatted = LocalDate.of(1900, 01, 01);
		}
		
		this.dob = dobFormatted;
	}

	@Column(unique=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
