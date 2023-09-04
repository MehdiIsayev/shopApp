package com.example.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orderitems")

public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private Long id;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "creationtime")
    private LocalDateTime creationtime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "updatetime")
    private LocalDateTime updatetime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

}
