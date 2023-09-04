package com.example.shop.service;

import com.example.shop.dto.ShoppingSesionDto;
import com.example.shop.dto.request.ShoppingRequest;
import com.example.shop.entity.ShoppingSesion;

import java.util.List;

public interface ShoppingSesionService {
    ShoppingSesionDto getShoppingsServiceById(Long id);
    void  updateShoppingSesion (ShoppingRequest shoppingRequest);
    void  saveShoppingSesion(ShoppingRequest shoppingRequest);


    void  deleteShoppingServiceById(Long id);
    List<ShoppingSesionDto> getAll();

}
