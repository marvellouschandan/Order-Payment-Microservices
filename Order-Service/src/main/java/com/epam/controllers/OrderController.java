package com.epam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.models.TransactionRequest;
import com.epam.models.TransactionResponse;
import com.epam.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		
		return orderService.saveOrder(request);
	}
}
