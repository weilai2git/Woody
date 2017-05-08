package com.future.tech.woody.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.tech.woody.controller.vo.OrderVO;
import com.future.tech.woody.domain.Order;
import com.future.tech.woody.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public OrderVO load(@PathVariable int orderId) {
		Order order = orderService.queryById(orderId);
		OrderVO orderVO = new OrderVO();
		orderVO.setId(order.getId());
		orderVO.setOrderAmount(order.getOrderAmount());
		orderVO.setPayStatus(order.getPayStatus());
		orderVO.setStatus(order.getStatus());
		orderVO.setUserId(order.getUserId());
		orderVO.setAddDate(order.getAddDate());
		return orderVO;
	}
	
	@RequestMapping(value = "hi", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String hi(){
		return "hello woody!";
	}
}
