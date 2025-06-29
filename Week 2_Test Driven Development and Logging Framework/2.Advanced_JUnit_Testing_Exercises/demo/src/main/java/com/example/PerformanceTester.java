package com.example;

public class PerformanceTester {

    public void performTask() {
        try {
            // Simulate time-consuming task
            Thread.sleep(500);  // Sleep for 500 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
