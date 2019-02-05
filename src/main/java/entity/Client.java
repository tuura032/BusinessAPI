package entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	private long clientId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate DOB;
	// also need orders (List<Order>)
	// wt
	// height
	// bmi/bodyfat
	// make a sub class?
	
	
	// I might need to delete this...?????????
	public Client(long customerId, String firstName, String lastName, String email, String phone, LocalDate DOB) {
		this.setCustomerId(customerId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setDOB(DOB);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCustomerId() {
		return clientId;
	}

	public void setCustomerId(long clientId) {
		this.clientId = clientId;
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

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
}
