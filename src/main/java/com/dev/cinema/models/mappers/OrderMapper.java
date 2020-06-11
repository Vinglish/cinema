package com.dev.cinema.models.mappers;

import com.dev.cinema.models.Order;
import com.dev.cinema.models.Ticket;
import com.dev.cinema.models.dto.order.OrderResponseDto;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto entityToDto(Order order) {
        var id = order.getId();
        var userId = order.getUser().getId();
        var orderTime = order.getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        List<Long> ticketsId = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        return new OrderResponseDto(id, userId, orderTime, ticketsId);
    }
}
