package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.OrderRepository;
import com.app.dto.ItemDto;
import com.app.dto.OrderStatus;
import com.app.dto.PlaceOrderDto;
import com.app.entity.Order;
import com.app.entity.OrderItem;
import com.app.entity.Product;
import com.app.entity.Status;
import com.app.entity.User;

@Service
@Transactional
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private StatusRepository statusRepo;
	
	@Autowired
	private IProductService productService;

	@Override
	public void createNewOrder(User user, PlaceOrderDto orderDto) {
		Order newOrder = new Order();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setTotalAmount(orderDto.getTotalAmount());
		newOrder.setUser(user);
		newOrder.setShippingAddress(user.getAddress());
		newOrder.setStatus(new Status(1,OrderStatus.valueOf("PROCESSING")));
		orderRepo.save(newOrder);
		
		List<ItemDto> Items = orderDto.getItems();
		Items.forEach(i->System.err.println(i));
		for(ItemDto dto : Items) {
			Product product = productService.getProductDetails(dto.getProductId());
			OrderItem oItem = new OrderItem();
			oItem.setUnitPrice(product.getPrice());
			oItem.setQuantity(dto.getQuantity());
			oItem.setSubTotal((dto.getQuantity())*(product.getPrice()));
			oItem.setProduct(product);
			oItem.setOrder(newOrder);
			orderItemRepo.save(oItem);
		}
		
	}

	@Override
	public List<Order> fetchOrderList(User user) {
		return orderRepo.findAllByUserOrderByOrderDateDesc(user);
	}

	@Override
	public Order getOrder(long orderId) {
		return orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Invalid orderId..!, order with given orderId doesn't exits..!"));
	}

	@Override
	public void updateOrderStatus(Long orderId, Integer statusId) {
		Order order = orderRepo.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Invalid orderId..!, order with given orderId doesn't exits..!"));
		Status status = statusRepo.findById(statusId).orElseThrow(()->new ResourceNotFoundException("Invalid statusId..!"));
		order.setStatus(status);
	}

	@Override
	public List<Status> fetchAllStatus() {
		
		return statusRepo.findAll();
	}
}
