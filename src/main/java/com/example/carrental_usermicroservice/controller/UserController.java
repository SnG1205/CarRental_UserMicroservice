package com.example.carrental_usermicroservice.controller;

import com.example.carrental_usermicroservice.dto.LoginRequest;
import com.example.carrental_usermicroservice.dto.LoginResponse;
import com.example.carrental_usermicroservice.model.User;
import com.example.carrental_usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/login")
    public LoginResponse register(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return user.map(value -> new LoginResponse(value.getId())).orElseGet(() -> new LoginResponse(""));
    }
}
