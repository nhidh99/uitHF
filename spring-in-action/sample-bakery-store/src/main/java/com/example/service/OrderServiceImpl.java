package com.example.service;

import com.example.config.JwtTokenProvider;
import com.example.dao.OrderDAO;
import com.example.model.Order;
import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Override
    @GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findMyOrders(@AuthenticationPrincipal User user) {
        List<Order> orders = orderDAO.findByUserId(user.getId());
        return ResponseEntity.ok().body(orders);
    }
}