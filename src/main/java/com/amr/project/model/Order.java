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
    @ManyToMany
    private Collection<Item> items;
    @Column
    private Calendar date;
    @OneToOne
    private Status status;
    @OneToOne
    private Address deliveryAddress;
    @Column
    private double total;

    public Order() {
    }

    public Order(Long id, Collection<Item> items, Calendar date, Status status, Address deliveryAddress, double total) {
        this.id = id;
        this.items = items;
        this.date = date;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
