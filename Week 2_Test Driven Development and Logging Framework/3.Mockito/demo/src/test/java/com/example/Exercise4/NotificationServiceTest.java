package com.example.Exercise4;

import com.example.NotificationService;
import com.example.UserApi;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testNotifyUserCallsSendEmail() {
        // Step 1: Create mock
        UserApi mockUserApi = mock(UserApi.class);

        // Step 2: Inject mock into service
        NotificationService service = new NotificationService(mockUserApi);

        // Step 3: Call the method
        service.notifyUser("test@example.com");

        // Step 4: Verify that the void method was called with expected arguments
        verify(mockUserApi).sendEmail("test@example.com", "Welcome!");
    }
}
