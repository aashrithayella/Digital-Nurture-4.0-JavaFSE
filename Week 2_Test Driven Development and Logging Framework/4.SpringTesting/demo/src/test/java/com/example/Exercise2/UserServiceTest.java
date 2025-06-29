package com.example.Exercise2;

import com.example.User;
import com.example.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        UserService userService = new UserService();
        User user = userService.getUserById(1L);  // ✅ fix here
        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());     // or match real name
    }
}
