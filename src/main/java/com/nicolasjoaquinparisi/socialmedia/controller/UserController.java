package com.nicolasjoaquinparisi.socialmedia.controller;

import com.nicolasjoaquinparisi.socialmedia.entity.User;
import com.nicolasjoaquinparisi.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody @Valid User user) {
        return this.userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }
}