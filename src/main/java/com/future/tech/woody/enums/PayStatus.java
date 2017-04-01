package com.future.tech.woody.enums;

import lombok.Getter;

public enum PayStatus {
	INIT(1),
	PAYING(2),
	SUCC(3),
	FAILED(4);
	
	@Getter
	private final int code;
	
	private PayStatus(int code) {
		this.code = code;
	}
}
