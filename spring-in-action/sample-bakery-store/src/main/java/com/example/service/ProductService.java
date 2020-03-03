package com.example.service;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> findAllProducts();
}
