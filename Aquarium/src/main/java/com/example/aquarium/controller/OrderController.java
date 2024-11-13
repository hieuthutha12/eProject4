package com.example.aquarium.controller;


import com.example.aquarium.bean.response.ChartData;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Integer id) {
        return orderService.findById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> responses = orderService.getAllOrders();
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/overview")
    public List<ChartData> getOverviewData() {
        return orderService.getLastSixMonthsRevenue();
    }

    @GetMapping("/details")
    public List<ChartData> getDetailsData() {
        return orderService.getWeeklySalesData();
    }
}

