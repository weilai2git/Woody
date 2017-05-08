package com.future.tech.woody.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.tech.woody.dao.OrderDao;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.factory.OrderFactory;
import com.future.tech.woody.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderFactory orderFactory;
	
	@Autowired
	private OrderDao orderDao;
	
	/* (non-Javadoc)
	 * @see com.future.tech.woody.service.OrderService#create(int, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Order create(int userId, String currency, BigDecimal amount) {
		Order order = orderFactory.make(userId, currency, amount);
		orderDao.insert(order);
		return order;
	}
	
	/* (non-Javadoc)
	 * @see com.future.tech.woody.service.OrderService#payForOrder(int)
	 */
	@Override
	public Order payForOrder(int orderId) {
		Order order = orderDao.query(orderId);
		if ( order.prepare2Pay() ) {
			if ( orderDao.update(order) > 0 ) {
				return order;
			}
			throw new IllegalAccessError("Error to update");
		} else {
			throw new IllegalArgumentException("Error to prepare");
		}
	}

	@Override
	public Order queryById(int orderId) {
		return orderDao.query(orderId);
	}
}
