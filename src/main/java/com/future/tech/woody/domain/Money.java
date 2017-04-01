package com.future.tech.woody.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
	private String currency;
	private BigDecimal amount;
}
