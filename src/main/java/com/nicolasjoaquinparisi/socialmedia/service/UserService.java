package com.nicolasjoaquinparisi.socialmedia.service;

import com.nicolasjoaquinparisi.socialmedia.entity.User;
import com.nicolasjoaquinparisi.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public Boolean findByUsername(String username) {
        return this.userRepository.selectExistsUsername(username);
    }
}
