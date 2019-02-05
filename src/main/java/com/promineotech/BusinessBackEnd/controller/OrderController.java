package com.promineotech.BusinessBackEnd.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Order;
import service.OrderService;

public class OrderController {

	OrderService os;
	
	// GET all orders from a customer (by id)
	@RequestMapping(value="/client/{id}/orders")
	public Iterable<Order> getClientOrders(@PathVariable Iterable<Long> id) {
		return os.getCustomerOrders(id);
	}
	
	// GET a specific order (order id) 
	@RequestMapping(value="/orders/{id}/{orderId}")
	public Order getOrder(@PathVariable long id, @PathVariable long orderId) {
		return os.getOrder(orderId);
	}
	
	// Update a specific order
	@RequestMapping(value="/orders/{id}/{orderId}", method=RequestMethod.PUT)
	public Order updateOrder(@PathVariable long id, @PathVariable long orderId, @RequestBody Order order) {
		return os.updateOrder(orderId, order);
	}
	
	
	// Create a new order
	@RequestMapping(value="/orders", method=RequestMethod.POST)
	public Order newOrder(@RequestBody Order order) {
		return os.createOrder(order);
	}
	

}
