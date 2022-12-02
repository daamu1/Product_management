package com.example.productmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {
	private Long orderId;
	private String orderName;
	private Date orderedDate;
	private Date orderDeliveryDate;
	private Boolean orderStatus;
	private UserDto userDto;
	private AddressDto addressDto;
	private List<ProductDto> productDto;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserDto getUserDao() {
		return userDto;
	}

	public void setUserDao(UserDto userDto) {
		this.userDto = userDto;
	}

	public AddressDto getAddressDao() {
		return addressDto;
	}

	public void setAddressDao(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public List<ProductDto> getProductDao() {
		return productDto;
	}

	public void setProductDao(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

	public void addOrderDao(ProductDto productDtos) {
		if (productDto == null)
			productDto = new ArrayList<>();
		productDto.add(productDtos);
		productDtos.setOrderDao(this);

	}

}
