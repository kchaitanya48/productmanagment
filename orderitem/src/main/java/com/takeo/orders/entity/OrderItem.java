package com.takeo.orders.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	/*
	 * @Column(name = "product_id") private int productId;
	 */
	
	
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
	private Order orders;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products product;
	
	public OrderItem() {
		
	}
	
	




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}



	public Products getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product = product;
	}




	
	
	

}
