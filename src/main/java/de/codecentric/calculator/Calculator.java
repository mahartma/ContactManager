package de.codecentric.calculator;

import java.math.BigDecimal;

public class Calculator {

	public BigDecimal add(Number number1, Number number2) {
		return new BigDecimal(number1.doubleValue() + number2.doubleValue());
	}
	
}
