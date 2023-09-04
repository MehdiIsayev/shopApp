package com.example.shop.dto.request;

import com.example.shop.entity.PaymentDetail;
import com.example.shop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailRequest {
    private Long id;
    private Float total;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
    private User userid;
    private PaymentDetail paymentDetail;

}
