package com.example.productmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
	private Long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long phoneNumber;
	private List<AddressDto> addressDto;
	private List<OrderDto> orderDto;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// add convenience methods for bi-directional relationship

	public List<AddressDto> getAddressDao() {
		return addressDto;
	}

	public void setAddressDao(List<AddressDto> addressDto) {
		this.addressDto = addressDto;
	}

	public List<OrderDto> getOrderDao() {
		return orderDto;
	}

	public void setOrderDao(List<OrderDto> orderDto) {
		this.orderDto = orderDto;
	}

	public void addAddress(AddressDto tempAddressDao) {

		if (addressDto == null) {
			addressDto = new ArrayList<>();
		}

		addressDto.add(tempAddressDao);
		tempAddressDao.setUserDao(this);
	}

	public void addOrder(OrderDto tempOrderDao) {
		if (orderDto == null)
			orderDto = new ArrayList<>();
		orderDto.add(tempOrderDao);
		tempOrderDao.setUserDao(this);

	}
}
