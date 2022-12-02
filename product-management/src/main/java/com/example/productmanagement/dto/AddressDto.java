package com.example.productmanagement.dto;

import java.util.List;

public class AddressDto {
	private Long productId;
	private String productName;
	private Double productPrice;

	private UserDto userDto;

	private List<OrderDto> orderDto;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public UserDto getUserDao() {
		return userDto;
	}

	public void setUserDao(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<OrderDto> getOrderDao() {
		return orderDto;
	}

	public void setOrderDao(List<OrderDto> orderDto) {
		this.orderDto = orderDto;
	}

}
