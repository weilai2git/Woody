package com.future.tech.woody.domain;

import java.util.Date;

import com.future.tech.woody.enums.OrderStatus;
import com.future.tech.woody.enums.PayStatus;

import lombok.Data;

@Data
public class Order {
	private int id;
	private int status;
	private Money orderAmount;
	private int userId;
	private Date addDate;
	private int payStatus;
	
	public boolean prepare2Pay() {
		if (status == OrderStatus.INIT.getCode() && payStatus == PayStatus.INIT.getCode()) {
			payStatus = PayStatus.PAYING.getCode();
			return true;
		} else {
			return false;
		}
	}
}
