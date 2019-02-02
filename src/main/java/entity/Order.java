package entity;

public class Order {

	private int orderId;
	private int customerId;
	
	public Order(int orderId, int customerId) {
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
	}
	
	public Order() {
		// it worked when I added this?
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
