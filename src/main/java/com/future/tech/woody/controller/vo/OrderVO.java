package com.future.tech.woody.controller.vo;

import java.util.Date;

import com.future.tech.woody.domain.Money;

import lombok.Data;

@Data
public class OrderVO {
	private int id;
	private int status;
	private Money orderAmount;
	private int userId;
	private Date addDate;
	private int payStatus;
}
