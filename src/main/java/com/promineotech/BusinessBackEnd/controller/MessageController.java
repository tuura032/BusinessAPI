package com.promineotech.BusinessBackEnd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Client;
import entity.Message;
import entity.Order;

@RestController
public class MessageController {

	List<Message> allMessages = new ArrayList<Message>();
	List<Client> allClients = new ArrayList<Client>();
	List<Order> allOrders = new ArrayList<Order>();
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong order_counter = new AtomicLong();
	
	
	List<String> friends = new ArrayList<String>();
	
	
	// GET all messages
	@RequestMapping("/messages")
	public List<Message> displayMessage() {
		return allMessages;
	}
	
	// Create new messagse POST
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public String newMessage(@RequestBody String message) {
		Message newMessage = new Message(counter.incrementAndGet(), message);
		allMessages.add(newMessage);
		return "Message created: " + newMessage.getMessage() + "At time: " + newMessage.getDatetime();
	}
	
	// Delete a Message with message id
	@RequestMapping(value="/messages/{id}", method=RequestMethod.DELETE)
	public String deleteMessageByMessageId(@PathVariable long id) {
		Message deletedMessage = null;
		
		for (int i = 0, j = allMessages.size(); i < j; i++) {
			if (allMessages.get(i).getId() == id) {
				deletedMessage = allMessages.remove(i);
				return "Message Deleted: " + deletedMessage.getMessage();
			}
		}
		return "Message doens't exist";
	}
	
	// get information from a client
	@RequestMapping(value="/client/{id}")
	public Client getClient(@PathVariable long id) {
		for (Client client : allClients) {
			if (client.getCustomerId() == id) {
				System.out.println("Client name: " + client.getName());
				return client;
			}
		}
		return null;
	}
	
	// create new client. Might delete this? Or keep it?
	@RequestMapping(value="/client", method=RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		allClients.add(client);
		return client;
	}
	
	// Create a new order
	@RequestMapping(value="/orders", method=RequestMethod.POST)
	public Order newOrder(@RequestBody Order order) {
		allOrders.add(order);
		return order;
	}
	
	// Delete a client
	@RequestMapping(value="/client/{id}", method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable long id) {
		
		for (int i = 0, j = allClients.size(); i < j; i++) {
			if (allClients.get(i).getCustomerId() == id) {
				allClients.remove(i);
			}
		}
	}
	
	// Admin gets list of all clients
	@RequestMapping(value="/client")
	public List<Client> getAllClients() {
		return allClients;
	}
	
	// update client information
	@RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
	public Client updateClient(@PathVariable long id, @RequestBody Client updatedClient) {
		//return updateClient(send in stuff);
		
		// get client
		for (Client client : allClients) {
			if (client.getCustomerId() == id) {
				client.setCustomerId(updatedClient.getCustomerId());
				client.setName(updatedClient.getName());
				return client;
			}
		}
		return null;
	}
	
	
	// GET all orders from a customer (by id)
	@RequestMapping(value="/client/{id}/orders")
	public List<Order> getClientOrders(@PathVariable long id) {
		List<Order> allClientOrders = new ArrayList<Order>();
		for (Order order : allOrders) {
			if (order.getCustomerId() == id) {
				allClientOrders.add(order);
			}
		}
		
		return allClientOrders;
	}
	
	// GET a specific order (order id) 
	@RequestMapping(value="/orders/{id}/{orderId}")
	public Order getOrder(@PathVariable long id, @PathVariable long orderId) {
		for (Order order : allOrders) {
			if (order.getOrderId() == orderId) {
				return order;
			}
		}
		return null;
	}
	
	// Update a specific order
	@RequestMapping(value="/orders/{id}/{orderId}", method=RequestMethod.PUT)
	public Order updateOrder(@PathVariable long id, @PathVariable long orderId, @RequestBody Order o) {
		//return updateClient(send in stuff);
		
		// get client
		for (Order order : allOrders) {
			if (order.getOrderId() == orderId) {
				order.setCustomerId(o.getCustomerId());
				//order.setSessions(o.getSessions());
				return order;
			}
		}
		return null;
	}
	
}