package com.future.tech.woody.dao;


import com.future.tech.woody.domain.Order;

public interface OrderDao {
	int insert(Order order);
	
	Order query(int id);
	
	int update(Order order);
}
