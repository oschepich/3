package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "country")
@AllArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String country;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "country_city",
            joinColumns = { @JoinColumn(name = "country_id") },
            inverseJoinColumns = { @JoinColumn(name = "city_id") })
    private Collection<City> cities;

    public Country() {
    }
}
