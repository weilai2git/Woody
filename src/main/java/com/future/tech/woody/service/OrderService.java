package com.future.tech.woody.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.future.tech.woody.dao.OrderDao;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.factory.OrderFactory;

public class OrderService {
	
	@Autowired
	private OrderFactory orderFactory;
	
	@Autowired
	private OrderDao orderDao;
	
	public Order create(int userId, String currency, BigDecimal amount) {
		Order order = orderFactory.make(userId, currency, amount);
		orderDao.insert(order);
		return order;
	}
	
	public boolean payForOrder(int orderId) {
		Order order = orderDao.query(orderId);
		if ( order.prepare2Pay() ) {
			orderDao.update(order);
			return true;
		} else {
			return false;
		}
	}
}
