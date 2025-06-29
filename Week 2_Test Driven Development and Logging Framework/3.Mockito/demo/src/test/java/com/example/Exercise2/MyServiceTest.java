package com.example.Exercise2;

import com.example.ExternalApi;
import com.example.MyService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert (verify interaction)
        verify(mockApi).getData();
    }
}
