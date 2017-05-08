package com.future.tech.woody.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.alibaba.fastjson.JSON;import com.future.tech.woody.controller.vo.OrderVO;
import com.future.tech.woody.spring.AbstractSpringMVCTests;
import com.future.tech.woody.spring.DBTests;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, DBTests.class })
public class OrderControllerTests extends AbstractSpringMVCTests {

	private static String xmlDataSetName = "testOrderDataSet.xml";

	@Test
	public void load() throws Exception {
		String jsonResult = this.getMockMvc().perform(get("/hi")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		Assert.assertEquals(jsonResult, "hello woody!");
	}

	@Test
	public void query() throws Exception {
		this.recover(xmlDataSetName);
		String jsonResult = this.getMockMvc().perform(get("/order/1")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		OrderVO vo = JSON.parseObject(jsonResult, OrderVO.class);
		IDataSet dataSet = loadDataSet(xmlDataSetName);
		Assert.assertEquals(String.valueOf(vo.getId()), dataSet.getTable("test_order").getValue(0, "id"));
		Assert.assertEquals(vo.getOrderAmount().getCurrency(), dataSet.getTable("test_order").getValue(0, "currency"));
		Assert.assertEquals(String.valueOf(vo.getPayStatus()), dataSet.getTable("test_order").getValue(0, "pay_status"));
		Assert.assertEquals(String.valueOf(vo.getUserId()), dataSet.getTable("test_order").getValue(0, "user_id"));
	}
}
