package com.example.service;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> login(String username, String password);
    ResponseEntity<?> logout(String jwt);
}