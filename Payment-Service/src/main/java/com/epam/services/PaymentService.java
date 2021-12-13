package com.epam.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.models.Payment;
import com.epam.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public Payment findPaymentByOrderId(long orderId) {
		return paymentRepository.findByOrderId(orderId);
	}
}
