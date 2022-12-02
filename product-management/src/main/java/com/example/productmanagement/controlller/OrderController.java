package com.example.productmanagement.controlller;

import com.example.productmanagement.entity.OrderDetails;
import com.example.productmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<OrderDetails> retrieveAllOrderDetails(@PathVariable Long userId) {
		return orderService.retrieveAllOrderDetails(userId);
	}

	@GetMapping("/orders/{orderId}")
	public OrderDetails getSingleDetails(@PathVariable Long userId, @PathVariable Long orderId) {
		return orderService.getSingleOrderDetails(userId, orderId);
	}

	@PostMapping("/addresses/{addressId}/orders")
	public void addNewOrder(@PathVariable Long userId, @PathVariable Long addressId,
			@RequestBody OrderDetails orderDetails) {

		orderService.addNewOrder(userId, addressId, orderDetails);
	}

	@DeleteMapping("orders/{orderId}")
	public void deleteOrderDetails(@PathVariable Long userId, @PathVariable Long orderId) {
		System.out.println(userId + " "+orderId);
		orderService.deleteOrderDetail(userId, orderId);
	}

	@PutMapping("/addresses/{addressId}/orders/{orderId}")
	public void updateOrder(@PathVariable Long userId, @PathVariable Long addressId,
			@RequestBody OrderDetails orderDetails) {
		orderService.updateOrder(userId, addressId, orderDetails);
	}
}
