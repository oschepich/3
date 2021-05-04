package com.amr.project.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Collection;

@Component
@Entity
@Table(name = "users")
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
    @OneToOne
    private Gender gender;
    @Column
    private Calendar birthday;
    @OneToOne
    private Image images;
    @ManyToMany
    private Collection<Discount> discount;
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

    public User(Long id, String email, String username, String password, String phone, String firstName, String lastName, int age, Address address, Collection<Role> roles, Gender gender, Calendar birthday, Image images, Collection<Discount> discount, Collection<Coupon> coupons, Collection<Item> cart, Collection<Order> orders, Collection<Review> reviews, Collection<Shop> shops) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.roles = roles;
        this.gender = gender;
        this.birthday = birthday;
        this.images = images;
        this.discount = discount;
        this.coupons = coupons;
        this.cart = cart;
        this.orders = orders;
        this.reviews = reviews;
        this.shops = shops;
    }

    public Long getId() {
        return id;
    }

    public Collection<Shop> getShops() {
        return shops;
    }

    public void setShops(Collection<Shop> shops) {
        this.shops = shops;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public Collection<Discount> getDiscount() {
        return discount;
    }

    public void setDiscount(Collection<Discount> discount) {
        this.discount = discount;
    }

    public Collection<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Collection<Coupon> coupons) {
        this.coupons = coupons;
    }

    public Collection<Item> getCart() {
        return cart;
    }

    public void setCart(Collection<Item> cart) {
        this.cart = cart;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }
}
