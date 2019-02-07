package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.BusinessBackEnd.entity.Order;
import com.promineotech.BusinessBackEnd.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	// GET all orders from a customer (by id)
	@RequestMapping(value="/client/{customerId}/orders")
	public Iterable<Order> getClientOrders(@PathVariable Long customerId) {
		return service.getCustomerOrders(customerId);
	}
	
	// GET a specific order (order id) 
	@RequestMapping(value="/client/{id}/orders/{orderId}")
	public Order getOrder(@PathVariable long id, @PathVariable long orderId) {
		return service.getOrder(orderId);
	}
	
	// Update a specific order
	@RequestMapping(value="/client/{id}/orders/{orderId}", method=RequestMethod.PUT)
	public Order updateOrder(@PathVariable long id, @PathVariable long orderId, @RequestBody Order order) {
		return service.updateOrder(orderId, order);
	}
	
	
	// Create a new order
	@RequestMapping(value="/client/{clientId}/orders", method=RequestMethod.POST)
	public Order newOrder(@PathVariable Long clientId, @RequestBody Order order) {
		return service.createOrder(clientId, order);
	}
	

}
