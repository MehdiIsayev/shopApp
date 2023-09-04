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
@Table(name = "paymentdetail")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private  Float amount;
    private String provider;
    private String status;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "creationtime")
    private LocalDateTime creationtime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "updatetime")
    private LocalDateTime updatetime;



    @OneToOne(mappedBy = "paymentDetail", orphanRemoval = true)
    private OrderDetail orderDetail;

}
