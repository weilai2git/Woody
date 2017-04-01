package com.future.tech.woody.dao;

import org.springframework.stereotype.Repository;

import com.future.tech.woody.domain.Order;

@Repository
public interface OrderDao {
	int insert(Order order);
	
	Order query(int id);
	
	int update(Order order);
}
