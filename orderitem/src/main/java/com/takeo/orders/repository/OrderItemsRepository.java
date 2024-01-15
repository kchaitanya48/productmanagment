package com.takeo.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.orders.entity.OrderItem;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer>{

}
