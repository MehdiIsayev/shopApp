package com.example.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "username",unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "creationtime")
    private LocalDateTime creationtime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "updatetime")
    private LocalDateTime updatetime;

    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShoppingSesion> shoppingSesions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

}
