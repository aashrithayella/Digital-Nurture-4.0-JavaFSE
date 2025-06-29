package com.example.Exercise4;

import com.example.ExceptionThrower;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    void testNoExceptionThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        // No exception expected
        thrower.throwException(false);
    }
}
