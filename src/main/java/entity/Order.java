package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Order {

	private Long orderId;
	private Long clientId;
	private String orderDescription;
	//private Iterable<ProductOrder> productOrders;
	
	public Order(Long orderId, Long clientId, String orderDescription) {
		this.setOrderId(orderId);
		this.setClientId(clientId);
		this.setOrderDescription(orderDescription);
		//this.setProductOrders(customerId);
	}

	public Order() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
}
