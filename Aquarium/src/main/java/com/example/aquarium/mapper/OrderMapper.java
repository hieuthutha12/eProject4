package com.example.aquarium.mapper;

//import com.example.aquarium.bean.request.OrderRequest;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.Order;
import com.example.aquarium.model.User;
import com.example.aquarium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    public OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setUserId(order.getUser().getId());
        response.setTotalAmount(order.getTotalAmount());
        response.setStatus(order.getStatus());
        response.setPaymentMethod(order.getPaymentMethod());
        response.setDiscount(order.getDiscount());
        response.setCreatedAt(order.getCreatedAt());

        return response;
    }
}

