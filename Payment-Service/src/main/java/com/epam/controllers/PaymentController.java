package com.epam.controllers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.models.Payment;
import com.epam.services.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/payments")
	public Payment acceptPayment(@RequestBody Payment payment) {
		logger.info("Payment request accepted: " + payment);
		payment.setStatus(paymentProcessing());
		return paymentService.doPayment(payment);
	}
	
	public String paymentProcessing() {
		// Paytm logic
		return new Random().nextBoolean() ? "success" : "failed";
	}
	
	@GetMapping("/payments/{orderId}")
	public Payment fetchPaymentByOrderId(@PathVariable long orderId) {
		logger.info("Received request to find payment with order id: " + orderId);
		return paymentService.findPaymentByOrderId(orderId);
	}
}
