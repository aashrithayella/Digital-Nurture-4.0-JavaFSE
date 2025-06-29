package com.example.Exercise4;

import com.example.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorLifecycleTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange: Setup phase before each test
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created");
    }

    @After
    public void tearDown() {
        // Teardown phase after each test
        calculator = null;
        System.out.println("Teardown: Calculator instance cleaned up");
    }

    @Test
    public void testAddition() {
        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(20, 5);
        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    public void testDivision() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }
}
