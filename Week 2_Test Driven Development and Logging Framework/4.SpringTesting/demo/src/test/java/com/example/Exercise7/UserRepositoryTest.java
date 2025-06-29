package com.example.Exercise7;

import com.example.User;
import com.example.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        // Arrange
        userRepository.save(new User(1L, "Alice"));
        userRepository.save(new User(2L, "Bob"));
        userRepository.save(new User(3L, "Alice"));

        // Act
        List<User> result = userRepository.findByName("Alice");

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result).extracting(User::getName).containsOnly("Alice");
    }
}
