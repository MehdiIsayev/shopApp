package com.example.shop.service;

import com.example.shop.dto.DiscountDto;
import com.example.shop.dto.request.DiscountRequest;

import java.util.List;

public interface DiscountService {
    DiscountDto getDiscountById(Long id);
    void updateDiscount(DiscountRequest discountRequest);
    void saveDiscount(DiscountRequest discountRequest);
    void  deleteDiscountById(Long id);
    List<DiscountDto> getAll();

}
