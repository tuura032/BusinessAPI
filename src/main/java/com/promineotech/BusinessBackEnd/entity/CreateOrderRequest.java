package com.promineotech.BusinessBackEnd.entity;

import java.util.List;


public class CreateOrderRequest {

	private Order order;
	private List<Long> productIds;
	
	public CreateOrderRequest() {
	}
	
	public CreateOrderRequest(Order order, List<Long> productIds) {
		this.setOrder(order);
		this.setProductIds(productIds);
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Long> getProductIds() {
		return productIds;
	}
	
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
}
