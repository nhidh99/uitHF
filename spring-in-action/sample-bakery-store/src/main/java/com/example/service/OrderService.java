package com.example.service;

import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<?> findMyOrders(String jwt);
}