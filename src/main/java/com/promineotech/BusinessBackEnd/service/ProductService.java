package com.promineotech.BusinessBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.entity.Product;
import com.promineotech.BusinessBackEnd.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository repo;
	
	// create a product in the database
	public Product createProduct(Product product) {
		return repo.save(product);
	}
	
	// get product information
	public Product getProduct(Long productId) {
		return repo.findProductByProductId(productId);
	}
	
	public Iterable<Product> getProducts() {
		return repo.findAll();
	}
}
