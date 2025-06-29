package com.example.Exercise4;

import com.example.User;
import com.example.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFullFlow_getUserById() {
        // Save user to in-memory DB
        User user = new User(1L, "Integration Test User");
        userRepository.save(user);

        // Call REST endpoint
        String url = "http://localhost:" + port + "/users/1";
        User response = restTemplate.getForObject(url, User.class);

        // Verify response
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("Integration Test User");
    }
}
