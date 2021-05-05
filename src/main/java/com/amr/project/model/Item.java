package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items")
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private double price;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Category> categories;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Image> images;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Review> reviews;

    public Item() {
    }
}
