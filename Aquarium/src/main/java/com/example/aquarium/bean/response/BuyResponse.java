package com.example.aquarium.dto.response;

import com.example.aquarium.model.Ticket;
import com.example.aquarium.model.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuyResponse {
    private String userId;
    private String ticketId;
    private String type;
    private Integer number;
    private TicketStatus status;
    private LocalDateTime buyDate;
    private LocalDateTime expirationDate;
    private BigDecimal total;
}
