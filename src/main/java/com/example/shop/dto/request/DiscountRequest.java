package com.example.shop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DiscountRequest {
    private Long id;
    private String name;
    private String description;
    private Float discountprosentage;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;
}
