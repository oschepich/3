package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "shop")
@Data
@NoArgsConstructor
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
    @JoinTable(name = "shop_item",
            joinColumns = { @JoinColumn(name = "shop_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private Collection<Item> items;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "shop_review",
            joinColumns = { @JoinColumn(name = "shop_id") },
            inverseJoinColumns = { @JoinColumn(name = "review_id") })
    private Collection<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
