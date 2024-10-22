package com.example.aquarium.service;

import com.example.aquarium.bean.request.BuyRequest;
import com.example.aquarium.bean.request.OrderDetailsRequest;
import com.example.aquarium.bean.request.TicketRequest;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.*;
import com.example.aquarium.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final TypeRepository typeRepository;
    private final TicketRepository ticketRepository;
    private final LoyaltyPointsRepository loyaltyPointsRepository;
    @Value("${my.custom.defaultPoints}")
    private int defaultPoints;
    @Value("${my.custom.discountPercentage}")
    private BigDecimal discountPercentage;

    public BuyRequest buyTicket(BuyRequest buyRequest) {
        Order order = new Order();

        User user = userRepository.findById(buyRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        order.setUser(user);
        order.setTotalAmount(buyRequest.getTotalAmount());
        order.setStatus(buyRequest.getStatus());
        order.setPaymentMethod(buyRequest.getPaymentMethod());
        order.setDiscount(buyRequest.getDiscount());
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Order savedOrder = orderRepository.save(order);

        List<OrderDetailsRequest> orderDetailsRequests = buyRequest.getOrderDetailsRequests();
        System.out.println(orderDetailsRequests.size());
        if (!orderDetailsRequests.isEmpty()) {
            for (OrderDetailsRequest orderDetailsRequest : orderDetailsRequests) {
                List<TicketRequest> ticketRequests = orderDetailsRequest.getTicketRequest();
                int quan = ticketRequests.size();
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setOrder(savedOrder);
                orderDetail.setPrice(orderDetailsRequest.getPrice());
                orderDetail.setQuantity(quan);

                OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetail);

                System.out.println(ticketRequests.size());
                for (TicketRequest ticket : ticketRequests) {
                    Ticket tickets = new Ticket();
                    Type type = typeRepository.findById(ticket.getTypeId())
                            .orElseThrow(() -> new ResourceNotFoundException("Type not found with id: " + ticket.getTypeId()));

                    tickets.setOrderDetails(savedOrderDetails);
                    tickets.setPurchaseDate(ticket.getPurchaseDate());
                    tickets.setExpirationDate(ticket.getExpirationDate());
                    tickets.setStatus(ticket.getStatus());
                    tickets.setType(type);
                    Ticket savedTicket = ticketRepository.save(tickets);
                    updateLoyaltyPoints(buyRequest.getUserId());
                }
            }
        }
        return buyRequest;
    }
        private void updateLoyaltyPoints(Integer userId) {
        LoyaltyPoints loyaltyPoint = loyaltyPointsRepository.findByUserId(userId);
        if (loyaltyPoint == null){
            LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
            loyaltyPoints.setPoints(defaultPoints);
            loyaltyPoints.setCreatedAt(new Date());
            loyaltyPoints.setDiscountPercentage(discountPercentage);
            loyaltyPoints.setUser(userRepository.findById(userId).orElse(null));
            loyaltyPointsRepository.save(loyaltyPoints);
        }else {
            loyaltyPoint.setPoints(loyaltyPoint.getPoints() + defaultPoints);
            loyaltyPointsRepository.save(loyaltyPoint);
        }
    }
}
