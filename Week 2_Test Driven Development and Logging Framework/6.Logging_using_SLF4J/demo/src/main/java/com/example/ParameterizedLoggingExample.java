package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;
        String action = "logged in";

        // Parameterized logging using placeholders {}
        logger.info("User {} of age {} has {}", user, age, action);

        // Different log levels examples
        logger.warn("User {} tried to access a restricted area", user);
        logger.error("Failed login attempt for user {}", user);
    }
}
