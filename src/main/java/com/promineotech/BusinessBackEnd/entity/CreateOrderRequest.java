package com.promineotech.BusinessBackEnd.entity;

import java.util.List;


public class CreateOrderRequest {

	private Order order;
	private List<Long> serialIds;
	
	public CreateOrderRequest() {
	}
	
	public CreateOrderRequest(Order order, List<Long> SerialIds) {
		this.setOrder(order);
		this.setSerialIds(SerialIds);
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Long> getSerialIds() {
		return serialIds;
	}

	public void setSerialIds(List<Long> serialIds) {
		this.serialIds = serialIds;
	}
}
