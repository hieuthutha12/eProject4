package com.example.aquarium.controller;

import com.example.aquarium.bean.request.OrderRequest;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.service.OrderService;
import jakarta.validation.Valid;
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

//    @PostMapping
//    public ResponseEntity<MessageResponse> createOrder(@Valid @RequestBody OrderRequest request) {
//        OrderResponse response = orderService.createOrder(request);
//        return new ResponseEntity<>(new MessageResponse("Successfully!"), HttpStatus.CREATED);
//    }

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

//    @PutMapping("/{id}")
//    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Integer id, @Valid @RequestBody OrderRequest request) {
//        OrderResponse response = orderService.updateOrder(id, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
//        orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
}

