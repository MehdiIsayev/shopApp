package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDto {
    private String name;
    private String description;
    private Float discountprosentage;
    private LocalDateTime creationtime;
    private LocalDateTime updatetime;

}
