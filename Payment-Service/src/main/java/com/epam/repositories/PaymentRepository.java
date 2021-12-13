package com.epam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Payment findByOrderId(Long orderId);

}
