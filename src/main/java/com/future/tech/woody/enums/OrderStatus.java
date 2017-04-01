package com.future.tech.woody.enums;

import lombok.Getter;

public enum OrderStatus {
	INIT(1),
	SUCC(2),
	FAILED(3);
	
	@Getter
	private final int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
}
