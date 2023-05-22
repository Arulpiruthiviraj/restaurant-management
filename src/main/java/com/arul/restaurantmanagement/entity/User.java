package com.arul.restaurantmanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;

    private String contactNumber;

    private String status;

    private String role;
}
