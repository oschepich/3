package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Data
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_index")
    private String cityIndex;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;

    @Column
    private String street;

    @Column
    private String house;
}