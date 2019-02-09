package com.promineotech.BusinessBackEnd.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long productId;
	
	private String productName;
	
//	private Long quantity;
	
	private String price;
	
	@ManyToMany(mappedBy = "products")
	List<Order> orders;
	
	public Product() {
	}
	
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}

//	public Long getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(Long quantity) {
//		this.quantity = quantity;
//	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
