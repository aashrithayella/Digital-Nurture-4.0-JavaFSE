package com.example.Exercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {
    @Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
