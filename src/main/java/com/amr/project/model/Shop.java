package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "shops")
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
    @OneToOne
    private Country location;
    @ManyToMany
    private Collection<Item> items;
    @ManyToMany
    private Collection<Review> reviews;

    public Shop() {
    }
}
