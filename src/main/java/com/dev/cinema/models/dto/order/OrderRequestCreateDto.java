package com.dev.cinema.models.dto.order;

import com.dev.cinema.models.Ticket;
import java.util.List;
import lombok.Getter;

@Getter
public class OrderRequestCreateDto {
    private List<Ticket> tickets;
    private Long id;

}
