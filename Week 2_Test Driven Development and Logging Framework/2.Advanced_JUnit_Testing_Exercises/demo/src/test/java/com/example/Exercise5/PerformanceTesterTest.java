package com.example.Exercise5;

import com.example.PerformanceTester;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithinTime() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(Duration.ofMillis(1000), () -> {
            tester.performTask(); // Should complete within 1 second
        });
    }
}
