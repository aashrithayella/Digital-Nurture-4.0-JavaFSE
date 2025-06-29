package com.example.Exercise6;

import com.example.ExternalApi;
import org.mockito.InOrder;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class InteractionOrderTest {

    @Test
    public void testMethodCallOrder() {
        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Call methods in a specific order
        mockApi.connect();
        mockApi.getData();
        mockApi.disconnect();

        // Step 3: Verify method call order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).disconnect();
    }
}
