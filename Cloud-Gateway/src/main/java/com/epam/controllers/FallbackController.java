package com.epam.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	@RequestMapping("/fallback/orders")
	public Mono<String> orderServiceFallack(){
		return Mono.just("Order service is taking too long to respond or is down. Please try again later!");
	}
	
	@RequestMapping("/fallback/payments")
	public Mono<String> paymentServiceFallack(){
		return Mono.just("Payment service is taking too long to respond or is down. Please try again later!");
	}
}
