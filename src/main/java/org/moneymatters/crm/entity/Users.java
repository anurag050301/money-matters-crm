package org.moneymatters.crm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Key;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //User information
    @Column(nullable = false, unique = true, name = "username")
    private String username;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String country;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Orders> orders;
}