package com.future.tech.woody.unit;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.future.tech.woody.domain.Order;
import com.future.tech.woody.enums.OrderStatus;
import com.future.tech.woody.enums.PayStatus;
import com.future.tech.woody.factory.OrderFactory;

public class OrderTests {
	private Order target;
	
	private OrderFactory orderFactory;
	
	private int userId;
	
	private String currency;
	
	private BigDecimal amount;
	
	@Before
	public void setup() {
		// init orderFactory
		orderFactory = new OrderFactory();
		userId = 1;
		currency = "RMB";
		amount = BigDecimal.valueOf(100L);
	}
	
	@Test
	public void prepare2PaySucc() {
		target = orderFactory.make(userId, currency, amount);
		Assert.assertTrue(target.prepare2Pay());
	}
	
	@Test
	public void prepare2PayFailedWithWrongStatus() {
		target = orderFactory.make(userId, currency, amount);
		//assume status is success
		target.setStatus(OrderStatus.SUCC.getCode());
		Assert.assertFalse(target.prepare2Pay());
	}
	
	@Test
	public void prepare2PayFailedWithWrongPayStatus() {
		target = orderFactory.make(userId, currency, amount);
		//assume pay status is failed
		target.setPayStatus(PayStatus.FAILED.getCode());;
		Assert.assertFalse(target.prepare2Pay());
	}
}
