package com.future.tech.woody.factory;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.future.tech.woody.domain.Money;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.enums.OrderStatus;
import com.future.tech.woody.enums.PayStatus;

@Component
public class OrderFactory {
	public Order make(int userId, String currency, BigDecimal amount) {
		Money money = new Money(currency, amount);
		Order order = new Order();
		order.setUserId(userId);
		order.setOrderAmount(money);
		order.setStatus(OrderStatus.INIT.getCode());
		order.setPayStatus(PayStatus.INIT.getCode());
		return order;
	}
}
