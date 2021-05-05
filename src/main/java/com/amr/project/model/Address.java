package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cityIndex;
    @OneToOne
    private Country country;
    @OneToOne
    private City city;
    @Column
    private String street;
    @Column
    private String house;

    public Address() {
    }
}
