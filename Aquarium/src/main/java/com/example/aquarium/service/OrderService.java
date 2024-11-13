package com.example.aquarium.service;
import com.example.aquarium.bean.response.ChartData;
import com.example.aquarium.bean.response.OrderResponse;
import com.example.aquarium.mapper.OrderMapper;
import com.example.aquarium.model.Order;
import com.example.aquarium.model.OrderDetails;
import com.example.aquarium.model.Ticket;
import com.example.aquarium.repository.OrderDetailsRepository;
import com.example.aquarium.repository.OrderRepository;
import com.example.aquarium.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.math.BigDecimal;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;


    private final OrderMapper orderMapper;
    private final OrderDetailsRepository orderDetailsRepository;
    private final TicketRepository ticketRepository;


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

    public List<ChartData> getLastSixMonthsRevenue() {
        LocalDateTime sixMonthsAgo = LocalDateTime.now().minusMonths(6);

        Map<String, BigDecimal> revenueByMonth = orderRepository.findAll().stream()
                .filter(order -> {
                    LocalDateTime createdAt = order.getCreatedAt().toLocalDateTime();
                    return createdAt.isAfter(sixMonthsAgo);
                })
                .collect(Collectors.groupingBy(
                        order -> order.getCreatedAt().toLocalDateTime().getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                        Collectors.mapping(
                                Order::getTotalAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        return revenueByMonth.entrySet().stream()
                .map(entry -> new ChartData(entry.getKey(), entry.getValue().longValue()))
                .collect(Collectors.toList());
    }

    public List<ChartData> getWeeklySalesData() {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime startOfWeek = currentDate.minusWeeks(5);

        List<OrderDetails> orderDetailsList = orderDetailsRepository.findAll();
        List<Ticket> tickets = ticketRepository.findAll();

        Map<String, BigDecimal> weeklySales = tickets.stream()
                .filter(ticket -> ticket.getExpirationDate().isAfter(startOfWeek))
                .collect(Collectors.groupingBy(
                        ticket -> "Tuần " + getWeekOfYear(ticket.getExpirationDate()),
                        Collectors.mapping(ticket -> {
                            Optional<OrderDetails> orderDetail = orderDetailsList.stream()
                                    .filter(od -> od.getId() == ticket.getOrderDetails().getId())
                                    .findFirst();
                            if (orderDetail.isPresent()) {
                                BigDecimal quantity = new BigDecimal(orderDetail.get().getQuantity());
                                BigDecimal price = orderDetail.get().getPrice();

                                BigDecimal totalPrice = quantity.multiply(price);
                                return totalPrice;
                            }
                            return BigDecimal.ZERO;
                        }, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        return weeklySales.entrySet().stream()
                .map(entry -> new ChartData(entry.getKey(), entry.getValue().longValue()))
                .collect(Collectors.toList());
    }

    private int getWeekOfYear(LocalDateTime expirationDate) {
        return expirationDate.get(WeekFields.of(Locale.getDefault()).weekOfYear());
    }
}

