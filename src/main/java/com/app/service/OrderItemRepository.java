package com.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
