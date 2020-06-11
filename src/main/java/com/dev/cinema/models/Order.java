package com.dev.cinema.models;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    private LocalDateTime orderDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private List<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Order(LocalDateTime orderDate, List<Ticket> tickets, User user) {
        this.orderDate = orderDate;
        this.tickets = tickets;
        this.user = user;
    }
}
