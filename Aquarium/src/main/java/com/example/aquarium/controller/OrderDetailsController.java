package com.example.aquarium.controller;

import com.example.aquarium.bean.request.OrderDetailsRequest;
import com.example.aquarium.bean.response.OrderDetailsResponse;
import com.example.aquarium.service.OrderDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

//    @PostMapping
//    public ResponseEntity<OrderDetailsResponse> createOrderDetail(@Valid @RequestBody OrderDetailsRequest request) {
//        OrderDetailsResponse response = orderDetailsService.createOrderDetail(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity<List<OrderDetailsResponse>> getAllOrderDetails() {
        List<OrderDetailsResponse> responses = orderDetailsService.getAllOrderDetails();
        return ResponseEntity.ok(responses);
    }
}

