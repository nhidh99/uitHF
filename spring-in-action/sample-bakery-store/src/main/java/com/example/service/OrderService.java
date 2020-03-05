package com.example.service;

import com.example.model.User;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<?> findMyOrders(User user);
}