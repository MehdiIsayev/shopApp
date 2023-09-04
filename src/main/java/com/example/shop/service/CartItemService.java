package com.example.shop.service;

import com.example.shop.dto.CartItemsDto;
import com.example.shop.dto.request.CartItemsRequest;

import java.util.List;

public interface CartItemService {
    CartItemsDto getCartItemsById(Long id);
    void updateCartItems(CartItemsRequest cartItemsRequest);
    void saveCartItems(CartItemsRequest cartItemsRequest);
    void deleteCartItemsById(Long id);
    List<CartItemsDto> getAll();
}
