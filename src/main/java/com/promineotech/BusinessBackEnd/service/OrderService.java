package com.promineotech.BusinessBackEnd.service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	ProductRepository prepo;
	
	// return a single order by order id
	public Order getOrder(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	// return all orders
	public Iterable<Order> getOrders() {
		return repo.findAll();
	}
	
	// return all orders by client id
	public Iterable<Order> getCustomerOrders(Long clientId) {
		return repo.findOrdersByClientId(clientId);
	}
	
	// update an order
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
	public Order createOrder(Long clientId, CreateOrderRequest orderRequest) {
		
		// get order
		Order order = orderRequest.getOrder();
		
		// Put products onto order
		List<Product> productList = new ArrayList<Product>();
		for (Long serialId : orderRequest.getSerialIds()) {
			Product product = prepo.findProductBySerialId(serialId);
			productList.add(product);
		}
		order.setProductList(productList);
		
		// Set Total Cost
		double totalCost = 0;
		for (Product product : productList) {
			totalCost = totalCost + product.getPrice();
			product.getProductName();
		}
		order.setTotalPrice(totalCost);
		
		// associate order with client
		Client foundClient = crepo.findById(clientId).orElse(null);
		if (foundClient != null) {
			order.setClient(foundClient);
		}
		return repo.save(order);
	}

}
