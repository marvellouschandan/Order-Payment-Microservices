package com.epam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
