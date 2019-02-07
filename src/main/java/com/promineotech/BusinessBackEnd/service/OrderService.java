package com.promineotech.BusinessBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.*;
import com.promineotech.BusinessBackEnd.repository.*;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	ClientRepository crepo;
	
	// return a single order by order id
	public Order getOrder(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	// return all orders
	public Iterable<Order> getOrders() {
		return repo.findAll();
	}
	
	// return all messages by client id
	public Iterable<Order> getCustomerOrders(Long clientId) {
		return repo.findOrdersByClientId(clientId);
	}
	
	//update an order
	public Order updateOrder(Long id, Order order) {
		Order foundOrder = repo.findById(id).orElse(null);
		if (foundOrder != null) {
			foundOrder.setClient(order.getClient());
			foundOrder.setOrderDescription(order.getOrderDescription());
			repo.save(foundOrder);
		}
		return foundOrder;
	}
	
	//create new order
	public Order createOrder(Long clientId, Order order) {
		Client foundClient = crepo.findById(clientId).orElse(null);
		if (foundClient != null) {
			order.setClient(foundClient);
		}
		return repo.save(order);
	}

}
