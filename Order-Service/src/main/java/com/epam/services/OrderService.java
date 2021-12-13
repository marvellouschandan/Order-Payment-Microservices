package com.epam.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.models.Order;
import com.epam.models.Payment;
import com.epam.models.TransactionRequest;
import com.epam.models.TransactionResponse;
import com.epam.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		order = orderRepository.save(order);
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getAmount());
		// REST CALL
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payments", payment, Payment.class);
		response = paymentResponse.getStatus().equals("success") ? "Payment processing successful and order placed" : "Failure in payment API, order added to cart";
		logger.info("Order received: " + order + ", Payment response: " + paymentResponse);
		return new TransactionResponse(order, payment.getAmount(), paymentResponse.getTransactionId(), response);
	}
}
