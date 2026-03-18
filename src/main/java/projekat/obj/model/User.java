//package me.ecommerce.model;
//
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.Order;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Objects;
//
//@Entity
//@NamedQuery(name = User.GET_ALL_USERS, query = "Select u from User u")
//public class User {
//
//    public static final String GET_ALL_USERS = "GetAllUsers";
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
//    private Long id;
//
//    private String name;
//    private String email;
//
//    // adresa kao entitet za @OneToOne relaciju
//    @OneToOne(cascade = CascadeType.ALL)
//    private Address address;
//
//    // lista narudžbi za @OneToMany relaciju
//    private List<Order> orders = new ArrayList<>();
//
//    public User() {}
//
//    // get/set metode
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    public Address getAddress() { return address; }
//    public void setAddress(Address address) { this.address = address; }
//    public List<Order> getOrders() { return orders; }
//    public void setOrders(List<Order> orders) { this.orders = orders; }
//
//    // equals i hashCode u stilu profesora
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, email);
//    }
//}