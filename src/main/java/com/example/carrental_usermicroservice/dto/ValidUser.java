package com.example.carrental_usermicroservice.dto;

public class ValidUser {
    private String id;

    public ValidUser(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
