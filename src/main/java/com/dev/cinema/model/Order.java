package com.dev.cinema.model;

import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private List<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Order(List<Ticket> tickets, User user) {
        this.tickets = tickets;
        this.user = user;
    }
}
