package com.takeo.orders.dto;

import java.util.Set;

public class ProductOrders {
	
	private int userId;
	
	private Set<Items> items;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}


	
}
