// File: src/test/java/com/example/Exercise7/VoidExceptionTest.java
package com.example.Exercise7;

import com.example.ExternalApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class VoidExceptionTest {

    @Test
    public void testDisconnectThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub disconnect() to throw an exception
        doThrow(new RuntimeException("Disconnection failed")).when(mockApi).disconnect();

        // Assert exception is thrown
        assertThrows(RuntimeException.class, () -> mockApi.disconnect());

        // Verify interaction
        verify(mockApi).disconnect();
    }
}
