package com.future.tech.woody.mock;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;

import com.future.tech.woody.dao.OrderDao;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.factory.OrderFactory;
import com.future.tech.woody.service.OrderService;
import com.future.tech.woody.service.impl.OrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceMockTests {
	
	@Mock
	private OrderDao orderDao;
	@Spy
	@Autowired
	private OrderFactory orderFactory;
	
	@InjectMocks
	private OrderService target = new OrderServiceImpl();
	
	private int userId;
	
	private String currency;
	
	private BigDecimal amount;
	
	@Before
	public void setUp() {
		userId = 1;
		currency = "RMB";
		amount = BigDecimal.valueOf(100L);
	}
	
	@Test
	public void createWithSucc() {
		Mockito.when(orderDao.insert(Mockito.any(Order.class))).thenReturn(1);
		Order order = target.create(userId, currency, amount);
		Mockito.verify(orderDao).insert(order);
	}
	
	@Test(expected=UncategorizedSQLException.class)
	public void createWithSqlException() {
		Mockito.when(orderDao.insert(Mockito.any(Order.class)))
				.thenThrow(new UncategorizedSQLException("", "", new SQLException("")));
		target.create(userId, currency, amount);
	}
	
	@Test
	public void updateWithSucc() {
		Order order = mock(Order.class);
		when(order.prepare2Pay()).thenReturn(true);
		when(orderDao.query(anyInt())).thenReturn(order);
		when(orderDao.update(order)).thenReturn(1);
		int orderId = 100001;
		target.payForOrder(orderId);
		Mockito.verify(orderDao).query(orderId);
		Mockito.verify(orderDao).update(order);
	}
	
	@Test(expected=IllegalAccessError.class)
	public void updateWithExcepton() {
		Order order = mock(Order.class);
		when(order.prepare2Pay()).thenReturn(true);
		when(orderDao.query(anyInt())).thenReturn(order);
		when(orderDao.update(order)).thenReturn(0);
		int orderId = 100001;
		target.payForOrder(orderId);
		Mockito.verify(orderDao).query(orderId);
		Mockito.verify(orderDao).update(order);
	}
}
