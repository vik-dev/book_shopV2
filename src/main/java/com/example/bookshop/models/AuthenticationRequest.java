package com.example.bookshop.models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}
