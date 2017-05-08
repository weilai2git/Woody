package com.future.tech.woody.service;

import java.math.BigDecimal;

import com.future.tech.woody.domain.Order;

public interface OrderService {

	Order create(int userId, String currency, BigDecimal amount);

	Order payForOrder(int orderId);
	
	Order queryById(int orderId);
}