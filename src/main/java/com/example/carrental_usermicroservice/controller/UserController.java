package com.example.carrental_usermicroservice.controller;

import com.example.carrental_usermicroservice.model.User;
import com.example.carrental_usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
        //Todo notify BookingService about creation of user with Kafka message
    }
}
