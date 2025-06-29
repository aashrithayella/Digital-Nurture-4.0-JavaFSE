package com.example.Exercise3;

import com.example.UserApi;
import com.example.NotificationService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class NotificationServiceTest {

    @Test
    public void testSendEmailCalledWithCorrectArguments() {
        UserApi mockUserApi = mock(UserApi.class);
        NotificationService service = new NotificationService(mockUserApi);

        service.notifyUser("test@example.com");

        verify(mockUserApi).sendEmail(eq("test@example.com"), eq("Welcome!"));
    }
}
