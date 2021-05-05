package com.amr.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Collection;

enum Gender {
    MAN,
    WOMAN,
}

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column(unique = true)
    private String phone;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    @OneToOne
    private Address address;
    @ManyToMany
    private Collection<Role> roles;
    @Column
    private Gender gender;
    @Column
    private Calendar birthday;
    @OneToOne
    private Image images;
    @ManyToMany
    private Collection<Coupon> coupons;
    @ManyToMany
    private Collection<Item> cart;
    @ManyToMany
    private Collection<Order> orders;
    @ManyToMany
    private Collection<Review> reviews;
    @ManyToMany
    private Collection<Shop> shops;

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
