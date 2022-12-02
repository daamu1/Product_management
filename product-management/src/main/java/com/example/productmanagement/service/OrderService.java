package com.example.productmanagement.service;

import com.example.productmanagement.entity.Address;
import com.example.productmanagement.entity.OrderDetails;
import com.example.productmanagement.entity.User;
import com.example.productmanagement.repository.AddressRepository;
import com.example.productmanagement.repository.OrderDetailsRepository;
import com.example.productmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class OrderService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	@Autowired
	private AddressRepository addressRepository;

	public List<OrderDetails> retrieveAllOrderDetails(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			throw new RuntimeException("Given User Id is not valid");
		}
		return user.get().getOrderDetails();
	}

	public OrderDetails getSingleOrderDetails(Long userId, Long addressId) {
		User user = userRepository.findById(userId).get();
		OrderDetails orders = orderDetailsRepository.findById(addressId).get();
		if (orders.getUser().equals(user)) {
			return orders;
		}
		throw new RuntimeException("order with given id and User id is not avaible");

	}

	public void addNewOrder(Long userId, Long addressId, OrderDetails orderDetails) {
		User user = userRepository.findById(userId).get();
		Address address = addressRepository.findById(addressId).get();
		if (address.getUser().equals(user)) {
			orderDetails.setUser(user);
			orderDetails.setAddress(address);

			orderDetailsRepository.save(orderDetails);
		}
	}

	public void deleteOrderDetail(Long userId, Long orderId) {
		User user = userRepository.findById(userId).get();
		OrderDetails orders = orderDetailsRepository.findById(orderId).get();

//		if (orders.getUser().equals(user)) {
//			orderDetailsRepository.delete(orders);
//		}
//		else {
//			throw new RuntimeException("order with given id and User id is not avaible");
//
//		}
		try {
			orderDetailsRepository.deleteById(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateOrder(Long userId, Long addressId, OrderDetails orderDetails) {
		User user = userRepository.findById(userId).get();
		Address address = addressRepository.findById(addressId).get();
		if (address.getUser().equals(user)) {
			orderDetails.setUser(user);
			orderDetails.setAddress(address);

			orderDetailsRepository.save(orderDetails);
		}
	}
}
