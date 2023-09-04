package com.example.shop.dto.request;

import com.example.shop.entity.OrderDetail;
import com.example.shop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemsRequest {
    private Long id;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
    private OrderDetail orderDetail;
    private Product product;
}
