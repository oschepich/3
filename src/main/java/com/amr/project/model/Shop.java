package com.amr.project.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Component
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String location;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Item> items;

    public Shop() {
    }

    public Shop(Long id, String name, String location, Collection<Item> items) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
