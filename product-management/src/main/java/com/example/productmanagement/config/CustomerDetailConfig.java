package com.example.productmanagement.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.productmanagement.entity.Customer;
import com.example.productmanagement.repository.CustomerRepository;

@Service
public class CustomerDetailConfig implements UserDetailsService{
	@Autowired
	CustomerRepository customerRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password = null;
		List<GrantedAuthority> authorities = null;
		List<Customer> customer = customerRepository.findByEmail(username);
		if (customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		} else {
			userName = customer.get(0).getEmail();
			password = customer.get(0).getPwd();
			authorities = new ArrayList<>();

		}
		return new User(username, password, authorities);
	}
}
