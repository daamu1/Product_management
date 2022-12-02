package com.example.productmanagement.controlller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;
import com.example.productmanagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/orders/{orderId}")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> retrieveAllProduct(@PathVariable Long userId, @PathVariable Long orderId) {
		return productService.retrieveAllList(userId, orderId);
	}

	@GetMapping("/products/{productId}")
	public Product retrieveProduct(@PathVariable Long userId, @PathVariable Long orderId,
			@PathVariable Long productId) {
		return productService.retriveProduct(userId, orderId, productId);
	}

	@PostMapping("/products")
	public void addNewProduct(@PathVariable Long userId, @PathVariable Long orderId, @RequestBody Product product) {
		productService.addNewProduct(userId, orderId, product);
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable Long userId, @PathVariable Long orderId, @PathVariable Long productId) {
		productService.deleteProduct(userId, orderId, productId);
	}

}
