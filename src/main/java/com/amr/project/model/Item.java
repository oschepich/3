package com.amr.project.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Component
@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Category> categories;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Image> images;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Review> reviews;

    public Item() {
    }

    public Item(Long id, String name, String price, Collection<Category> categories, Collection<Image> images, Collection<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.images = images;
        this.reviews = reviews;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }
}
