package com.promineotech.BusinessBackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.BusinessBackEnd.entity.Product;
import com.promineotech.BusinessBackEnd.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository repo;
	
	// create a product in the database
	public Product createProduct(Product product) {
		//product.setLastUpdatedTime(LocalDateTime.now());
		return repo.save(product);
	}
	
	// get product information
	public Product getProduct(Long productId) {
		return repo.findProductBySerialId(productId);
	}
	
	// get a list of all products
	public Iterable<Product> getProducts() {
		return repo.findAll();
	}
	
	// update a product
	public Product updateProduct(Long productId, Product product) {
		Product foundProduct = repo.findById(productId).orElse(null);
		if (foundProduct != null) {
			foundProduct.setPrice(product.getPrice());
			foundProduct.setProductDescription(product.getProductDescription());
			foundProduct.setProductName(product.getProductName());
			foundProduct.setSerialId(product.getProductId());
		}
		return repo.save(foundProduct);
	}

	// delete a product
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
}
