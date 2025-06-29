package com.example.Exercise2;
import com.example.Calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest2 {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    public void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(3, calculator.divide(9, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
