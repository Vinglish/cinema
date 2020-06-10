package com.dev.cinema.models.dto.order;

import java.util.List;
import lombok.Getter;

@Getter
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private String orderDate;
    private List<Long> ticketsId;

    public OrderResponseDto(Long id, Long userId, String orderDate, List<Long> ticketsId) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.ticketsId = ticketsId;
    }
}
