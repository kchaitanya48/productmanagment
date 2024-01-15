package com.takeo.orders.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.orders.dto.Items;
import com.takeo.orders.dto.ProductOrders;
import com.takeo.orders.entity.Order;
import com.takeo.orders.entity.OrderItem;
import com.takeo.orders.entity.Products;
import com.takeo.orders.entity.Users;
import com.takeo.orders.repository.OrderItemsRepository;
import com.takeo.orders.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public void saveOrders(ProductOrders productOrders) {

		Order order = new Order();
		Users users = new Users();
		users.setUserId(productOrders.getUserId());
		//order.setUserId(productOrders.getUserId());
		order.setUser(users);
		orderRepository.save(order);

		OrderItem orderItems = new OrderItem();

		for (Items items : productOrders.getItems()) {
			Products products=new Products();
			products.setProductId(items.getProductId());
			orderItems.setProduct(products);
			orderItems.setQuantity(items.getQuantity());
			orderItems.setOrders(order);
			orderItemsRepository.save(orderItems);
		}

	}

	public Order getDetailsByuserId(Integer usreId) {
		//Optional<Order> order=orderRepository.findByUserId(usreId);
		return null;
		
	}

}
