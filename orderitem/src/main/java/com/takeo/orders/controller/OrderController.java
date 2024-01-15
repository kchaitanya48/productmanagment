package com.takeo.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.orders.dto.ProductOrders;
import com.takeo.orders.entity.Order;
import com.takeo.orders.service.OrderService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public void saveOrders(@RequestBody ProductOrders orders) {
		
		orderService.saveOrders(orders);
	}
	
	@GetMapping("/{id}")
	public Order getDetailsByUseName(@PathVariable("id") Integer userId) {
		return orderService.getDetailsByuserId(userId);
	}

}
