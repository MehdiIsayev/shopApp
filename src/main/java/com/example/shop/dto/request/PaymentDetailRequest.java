package com.example.shop.dto.request;

import com.example.shop.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailRequest {
    private Long id;
    private  Float amount;
    private String provider;
    private String status;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
    private OrderDetail orderDetail;
}
