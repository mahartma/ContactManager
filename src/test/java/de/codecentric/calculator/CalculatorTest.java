package de.codecentric.calculator;

import java.math.BigDecimal;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void shouldAddTwoNumbers() {
		//Given
		double number1 = 1;
		double number2 = 2;
		//When
		BigDecimal result = calculator.add(number1, number2);
		//Then
		Assert.assertThat(result.doubleValue(), CoreMatchers.is(3d));
	}
}
