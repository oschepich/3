package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "shop")
@AllArgsConstructor
@Getter
@Setter
public class Shop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Country location;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "shop_item")
    private Collection<Item> items;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "shop_review")
    private Collection<Review> reviews;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Shop() {
    }
}
