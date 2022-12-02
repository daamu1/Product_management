package com.example.productmanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productmanagement.entity.OrderDetails;
@Repository
@Transactional
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
