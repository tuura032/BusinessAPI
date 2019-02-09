package com.promineotech.BusinessBackEnd.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

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
		
		System.out.println("=========== ORDER SERVICE STARTS HERE ===========");
		Order order = orderRequest.getOrder();
		System.out.println(order.getOrderDescription());
		//Iterable<Long> idList = orderRequest.getProductIds();
		//List<Product> productList = prepo.findAllById(idList);
		
		
		List<Product> productList = new ArrayList<Product>();
	
		for (Long productId : orderRequest.getProductIds()) {
			Product product = prepo.findProductByProductId(productId);
			productList.add(product);
			System.out.println(product.getProductName());
		}
		

		// associate order and products with client
		Client foundClient = crepo.findById(clientId).orElse(null);
		if (foundClient != null) {
			//order.setProducts(productList);
			order.setClient(foundClient);
		}
		return repo.save(order);
	}

}
