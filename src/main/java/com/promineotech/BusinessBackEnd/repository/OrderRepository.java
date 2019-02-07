package com.promineotech.BusinessBackEnd.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.BusinessBackEnd.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	Iterable<Order> findOrdersByClientId(Long clientId);
}
