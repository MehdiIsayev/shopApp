package com.example.shop.dto.request;

import com.example.shop.entity.Discount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
    private Long id;
    private String name;
    private String description;
    private String sku;
    private String category;
    private Float price;
    private LocalDateTime updatetime;
    private LocalDateTime creationtime;
    private Discount discount;

}
