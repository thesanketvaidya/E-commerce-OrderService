package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Order;
import com.app.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findAllByUserOrderByOrderDateDesc(User user);
}
