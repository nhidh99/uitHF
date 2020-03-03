package com.example.service;

import com.example.config.JwtTokenProvider;
import com.example.dao.OrderDAO;
import com.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Override
    @GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findMyOrders(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        String token = jwt.substring(7);
        Long userId = tokenProvider.getUserIdFromJwt(token);
        List<Order> orders = orderDAO.findByUserId(userId);
        return ResponseEntity.ok().body(orders);
    }
}
