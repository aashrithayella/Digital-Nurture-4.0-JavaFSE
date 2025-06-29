package com.example.Exercise6;

import com.example.UserService;
import com.example.UserNotFoundException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testGetUserByIdThrowsExceptionForMissingUser() {
        UserService userService = new UserService();

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(99L); // ID not found
        });

        assertEquals("User with ID 99 not found", exception.getMessage());
    }
}
