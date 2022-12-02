package com.example.productmanagement.service;

import com.example.productmanagement.entity.Address;
import com.example.productmanagement.entity.User;
import com.example.productmanagement.repository.AddressRepository;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Address> retrieveAllAddresss(Long userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new RuntimeException("Given UserId is Not valid ");
		}
		return user.getAddresses();
	}

	public Address getAddressById(Long userId, Long addressId) {

		User user = userRepository.findById(userId).get();
		Address address = addressRepository.findById(addressId).get();
		if (address.getUser().equals(user)) {
			return address;
		}
		throw new RuntimeException("Address with given id and User id is not avaible");
	}

	public void addNewAddress(Long userId, Address address) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new RuntimeException("Given Userid Is not valid.." + userId);
		}
		address.setUser(user);
		addressRepository.save(address);
	}

	public void deleteAddressById(Long userId, Long addressId) {
		User user = userRepository.findById(userId).get();
		Address address = addressRepository.findById(addressId).get();
		if (address.getUser().equals(user)) {
			addressRepository.delete(address);
		} else {
			throw new RuntimeException("Given Userid Is not valid.." + userId);
		}
	}

	public Address updateAddress(Long userId, Address address) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			throw new RuntimeException("Given UserId is Not valid ");
		}
//		Optional<Address> addresss = addressRepository.findById(addressId);
//		if (addresss.isEmpty()) {
//			throw new UserNotFoundException("Given AddressId is Not valid ");
//		}
		user.get().addAddress(address);
		return addressRepository.save(address);
	}
}