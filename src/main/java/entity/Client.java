package entity;

public class Client {

	private long customerId;
	private String name;
	
	public Client(long customerId, String name) {
		this.setCustomerId(customerId);
		this.setName(name);
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
