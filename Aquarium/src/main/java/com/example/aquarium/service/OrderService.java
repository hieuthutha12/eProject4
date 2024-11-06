package com.example.aquarium.service;

//import com.example.aquarium.bean.request.OrderRequest;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.mapper.OrderMapper;
import com.example.aquarium.model.Order;
import com.example.aquarium.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;


    private final OrderMapper orderMapper;


    public Optional<OrderResponse> findById(int id) {
        return orderRepository.findById(id)
                .map(order -> orderMapper.toResponse(order));
    }
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }

}

