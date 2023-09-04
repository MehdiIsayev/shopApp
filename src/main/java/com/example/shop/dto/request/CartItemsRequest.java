package com.example.shop.dto.request;

import com.example.shop.entity.Product;
import com.example.shop.entity.ShoppingSesion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CartItemsRequest {
    private Long id;
    private Float quantity;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
    private ShoppingSesion shoppingSesionid;
    private Product product;
}
