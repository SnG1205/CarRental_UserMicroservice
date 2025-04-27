package com.example.carrental_usermicroservice.dto;

public class LoginResponse {
    private String id;
    //Todo possbile add token if decide for JWT

    public LoginResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
