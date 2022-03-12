package com.nicolasjoaquinparisi.socialmedia.service;

import com.nicolasjoaquinparisi.socialmedia.entity.User;
import com.nicolasjoaquinparisi.socialmedia.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    void itShouldCheckIfUserUserExistsUsername() {
        // Given
        String username = "pepe";
        User user = new User(
                username,
                "lala1234",
                "Pepe",
                "Grillo"
        );
        underTest.save(user);

        // When
        Boolean expected = underTest.selectExistsUsername("pepe");

        // Then
        assertThat(expected).isTrue();
    }
}
