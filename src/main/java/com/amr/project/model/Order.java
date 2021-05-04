package com.amr.project.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Component
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Item> items;
    @Column
    private Calendar date;

}
