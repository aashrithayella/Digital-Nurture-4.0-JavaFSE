package com.example.Exercise3;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC");
        assertTrue(true);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB");
        assertTrue(true);
    }
}
