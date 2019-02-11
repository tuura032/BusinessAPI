package com.promineotech.BusinessBackEnd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.BusinessBackEnd.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findProductBySerialId(Long serialId);
	
	List<Product> findAllById(Iterable<Long> productIds);
}
