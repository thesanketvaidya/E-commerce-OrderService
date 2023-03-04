package com.app.service;

import java.util.List;

import com.app.dto.PlaceOrderDto;
import com.app.entity.Order;
import com.app.entity.Status;
import com.app.entity.User;

public interface IOrderService {
	void createNewOrder(User user, PlaceOrderDto orderDto);

	List<Order> fetchOrderList(User user);

	Order getOrder(long orderId);

	void updateOrderStatus(Long orderId, Integer statusId);

	List<Status> fetchAllStatus();
}
