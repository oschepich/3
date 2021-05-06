package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "orders_item",
            joinColumns = { @JoinColumn(name = "orders_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private Collection<Item> items;

    @Column
    private Calendar date;

    @Column
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @Column
    private double total;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
