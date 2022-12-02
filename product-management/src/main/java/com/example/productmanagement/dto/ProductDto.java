package com.example.productmanagement.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.productmanagement.entity.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDto {
	private Long productId;
	private String productName;
	private Double productPrice;
	private OrderDto orderDto;

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

	public OrderDto getOrderDao() {
		return orderDto;
	}

	public void setOrderDao(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

}
