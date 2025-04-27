package com.example.carrental_usermicroservice.controller;

import com.example.carrental_usermicroservice.dto.LoginRequest;
import com.example.carrental_usermicroservice.dto.LoginResponse;
import com.example.carrental_usermicroservice.dto.ValidUser;
import com.example.carrental_usermicroservice.kafka.producer.KafkaProducerService;
import com.example.carrental_usermicroservice.model.User;
import com.example.carrental_usermicroservice.service.UserService;
import com.example.carrental_usermicroservice.util.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    private JsonConverter jsonConverter = new JsonConverter();

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/kafka")
    public String sendKafka() throws JsonProcessingException {
        ValidUser validUser = new ValidUser("sss");
        kafkaProducerService.sendUserCreatedMessage("user-created-topic1", jsonConverter.toJson(validUser));
        return "success";
    }

    @PostMapping
    public User register(@RequestBody User user) throws JsonProcessingException {
        User registeredUser = userService.registerUser(user);
        ValidUser validUser = new ValidUser(registeredUser.getId());
        kafkaProducerService.sendUserCreatedMessage("user-created-topic1", jsonConverter.toJson(validUser));
        return registeredUser;
        //Todo notify BookingService about creation of user with Kafka message
    }

    @PostMapping("/login")
    public LoginResponse register(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return user.map(value -> new LoginResponse(value.getId())).orElseGet(() -> new LoginResponse(""));
    }
}
