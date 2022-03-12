package com.nicolasjoaquinparisi.socialmedia.service;

import com.nicolasjoaquinparisi.socialmedia.entity.User;
import com.nicolasjoaquinparisi.socialmedia.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }

    @Test
    void canGetAllUsers() {
        // When
        underTest.getUsers();

        // Then
        verify(userRepository).findAll();
    }

    @Test
    void addUser() {
        // Given
        User user = new User(
                "pepe",
                "lalala123",
                "Pepe",
                "Grillo"
        );

        // When
        underTest.addUser(user);

        // Then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    @Disabled
    void findByUsername() {
    }
}