package com.example.productmanagement.repository;

import com.example.productmanagement.entity.Address;
import com.example.productmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    public List<Address> findByUser(User user);
}
