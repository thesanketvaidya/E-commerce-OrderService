package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PlaceOrderDto;
import com.app.entity.Order;
import com.app.entity.Status;
import com.app.entity.User;
import com.app.service.IAuthenticationService;
import com.app.service.IOrderService;
import com.app.service.IUserService;

@RestController 
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderService orderService;
	
//	@Autowired
//	private IAuthenticationService authService;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<?> placeOrder(@RequestBody PlaceOrderDto orderDto){
		
		System.out.println("in place order" + orderDto);
		
		
		User user = userService.getUserDetails(orderDto.getUserId());
		
		System.out.println("in place order " + user);
		
		orderService.createNewOrder(user, orderDto);
		
		return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
    public ResponseEntity<?> getOrderList(@PathVariable long userId) {
        

		
        User user = userService.getUserDetails(userId);
        // get orders
        List<Order> orderList = orderService.fetchOrderList(user);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
	
	@GetMapping("/{userId}/{orderId}")
    public ResponseEntity<?> getOrderById( @PathVariable long userId,@PathVariable long orderId) {
       

		
            Order order = orderService.getOrder(orderId);
            
            return new ResponseEntity<>(order,HttpStatus.OK);

    }
	
	@PutMapping("/{userId}/{orderId}/status/{statusId}")
	public ResponseEntity<?> updateOrderStatus( @PathVariable Long userId,@PathVariable Long orderId,@PathVariable Integer statusId ){
		orderService.updateOrderStatus(orderId, statusId);
		return new ResponseEntity<>(new ApiResponse(true, "Status changed successfully..!"), HttpStatus.OK);
	}
	
	@GetMapping("/status")
	public ResponseEntity<?> getAllStatus(){
		List<Status> statusList = orderService.fetchAllStatus();
		return new ResponseEntity<>(statusList,HttpStatus.OK);
	}
	
	
}
