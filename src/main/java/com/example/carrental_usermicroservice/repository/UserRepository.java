package com.example.carrental_usermicroservice.repository;


import com.example.carrental_usermicroservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
