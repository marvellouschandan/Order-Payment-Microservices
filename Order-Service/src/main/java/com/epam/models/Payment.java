package com.epam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private long id;
	private String status;
	private String transactionId;
	private long orderId;
	private double amount;
}
