package com.future.tech.woody.db;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.future.tech.woody.dao.OrderDao;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.enums.PayStatus;
import com.future.tech.woody.factory.OrderFactory;
import com.future.tech.woody.spring.DBTests;

@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        DBTests.class})
public class OrderDaoDBTests extends DBTests {
	@Autowired
	private OrderDao orderDao;

	private static String xmlDataSetName = "testOrderDataSet.xml";

	@Before
	public void setup() throws Exception {
		super.recover(xmlDataSetName);
	}
	
	@Test
	public void query() throws Exception {
		Order order = orderDao.query(1);
		IDataSet dataSet = loadDataSet(xmlDataSetName);
		Assert.assertEquals(String.valueOf(order.getId()), dataSet.getTable("test_order").getValue(0, "id"));
		Assert.assertEquals(order.getOrderAmount().getCurrency(), dataSet.getTable("test_order").getValue(0, "currency"));
		Assert.assertEquals(String.valueOf(order.getPayStatus()), dataSet.getTable("test_order").getValue(0, "pay_status"));
		Assert.assertEquals(String.valueOf(order.getUserId()), dataSet.getTable("test_order").getValue(0, "user_id"));
	}

	@Test
	public void insert() throws Exception {
		OrderFactory orderFactory = new OrderFactory();
		int userId = 1;
		String currency = "RMB";
		BigDecimal amount = BigDecimal.valueOf(100L);

		Order order = orderFactory.make(userId, currency, amount);
		int res = orderDao.insert(order);
		Assert.assertTrue(res == 1);
	}
	
	@Test
	public void update() {
		Order order = orderDao.query(1);
		order.prepare2Pay();
		orderDao.update(order);
		order = orderDao.query(1);
		Assert.assertTrue(order.getPayStatus() == PayStatus.PAYING.getCode());
	}

}
