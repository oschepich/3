package com.amr.project.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "addresses")
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

    public Address(Long id, String cityIndex, Country country, City city, String street, String house) {
        this.id = id;
        this.cityIndex = cityIndex;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCityIndex() {
        return cityIndex;
    }

    public void setCityIndex(String cityIndex) {
        this.cityIndex = cityIndex;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
