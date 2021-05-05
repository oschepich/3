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

@Entity
@Table(name = "user")
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
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column
    private int age;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role")
    private Collection<Role> roles;
    @Column
    private Gender gender;
    @Column
    private Calendar birthday;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Image images;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_coupon")
    private Collection<Coupon> coupons;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Item> cart;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_orders")
    private Collection<Order> orders;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_review")
    private Collection<Review> reviews;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_shop")
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
