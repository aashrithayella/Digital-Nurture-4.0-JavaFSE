package com.example.Exercise9;

import com.example.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "0, 0, 0",
        "-1, 1, 0",
        "10, 15, 25",
        "-5, -5, -10"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), () -> a + " + " + b + " should be " + expected);
    }
}
