package com.promineotech.BusinessBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.BusinessBackEnd.entity.Product;
import com.promineotech.BusinessBackEnd.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	// Create a new product
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Product newProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}
	
	// Get all products
	@RequestMapping(value="/product")
	public Iterable<Product> getAllProducts() {
		return service.getProducts();
	}
	
	// Get a product
	@RequestMapping(value="/product/{productId}")
	public Product getProduct(@PathVariable Long id) {
		return service.getProduct(id);
	}
	
//	// Create product order
//	@RequestMapping(value="/client/{clientId}/product/{productId}", method=RequestMethod.POST)
//	public Product addProduct
	
}
