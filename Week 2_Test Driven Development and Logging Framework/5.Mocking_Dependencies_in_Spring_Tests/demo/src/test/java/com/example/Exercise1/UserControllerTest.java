package com.example.Exercise1;

import com.example.User;
import com.example.UserController;
import com.example.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUser_ReturnsUser() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("John Doe");

        when(userService.getUserById(userId)).thenReturn(mockUser);

        ResponseEntity<User> response = userController.getUser(userId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockUser, response.getBody());

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    public void testGetUser_ReturnsNullWhenUserNotFound() {
        Long userId = 2L;
        when(userService.getUserById(userId)).thenReturn(null);

        ResponseEntity<User> response = userController.getUser(userId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());

        verify(userService, times(1)).getUserById(userId);
    }
}
