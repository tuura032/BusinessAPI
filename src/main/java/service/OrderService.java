package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Order;
//import entity.ProductOrder;
import repository.OrderRepository;

public class OrderService {

	@Autowired
	OrderRepository repo;
	
	//get a single order
	public Order getOrder(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	//get all orders
	public Iterable<Order> getOrders() {
		return repo.findAll();
	}
	
	//get all orders from one person
	public Iterable<Order> getCustomerOrders(Iterable<Long> customerId) {
		return repo.findAllById(customerId);
	}
	//update an order
	public Order updateOrder(long id, Order order) {
		Order foundOrder = repo.findById(id).orElse(null);
		if (foundOrder != null) {
			foundOrder.setClientId(order.getClientId());
			foundOrder.setOrderDescription(order.getOrderDescription());
			repo.save(foundOrder);
		}
		return foundOrder;
	}
	
	//create new order
	public Order createOrder(Order order) {
		return repo.save(order);
	}

}
