package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

enum Status {
    START,
    COMPLETE,
}

@Entity
@Table(name = "orders")
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Item> items;
    @Column
    private Calendar date;
    @Column
    private Status status;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address deliveryAddress;
    @Column
    private double total;

    public Order() {
    }
}
