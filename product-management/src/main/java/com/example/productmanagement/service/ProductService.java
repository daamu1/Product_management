package com.example.productmanagement.service;

import com.example.productmanagement.entity.OrderDetails;
import com.example.productmanagement.entity.Product;
import com.example.productmanagement.entity.User;
import com.example.productmanagement.repository.OrderDetailsRepository;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

@Service
public class ProductService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public List<Product> retrieveAllList(Long userId, Long orderId) {
		Optional<User> user = userRepository.findById(userId);
		{
			if (user.isEmpty()) {
				throw new UserNotFoundException("Given User Id is not valid.");
			}
		}
		Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderId);
		if (orderDetails.isEmpty()) {
			throw new UserNotFoundException("Order does not Exist");
		}
		return orderDetails.get().getProducts();
	}

	public Product retriveProduct(Long userId, Long orderId, Long productId) {
		User user = userRepository.findById(userId).get();
		OrderDetails orderDetails = orderDetailsRepository.findById(orderId).get();
		Product product = productRepository.findById(productId).get();
		if (orderDetails.getUser().equals(user) && product.getOrderDetails().equals(orderDetails)) {
			return product;
		}
		throw new RuntimeException("product with given id and product id is not avaible");

	}

	public void addNewProduct(Long userId, Long orderId, Product product) {
		User user = userRepository.findById(userId).get();
		OrderDetails orderDetails = orderDetailsRepository.findById(orderId).get();
		if (orderDetails.getUser().equals(user)) {
			product.setOrderDetails(orderDetails);
			productRepository.save(product);
		} else {
			throw new RuntimeException("product with given id and product id is not avaible");
		}
	}


	public void deleteProduct(Long userId ,Long orderId, Long productId) {
		User user = userRepository.findById(userId).get();
		OrderDetails orderDetails = orderDetailsRepository.findById(orderId).get();
		Product product=productRepository.findById(productId).get();
		if (orderDetails.getUser().equals(user)&& product.getOrderDetails().equals(orderDetails)) {
		
			productRepository.delete(product);
		} else {
			throw new RuntimeException("User, product with given id and product id is not avaible");
		}

	}
}