package com.example.shop.service.impl;

import com.example.shop.dto.CartItemsDto;
import com.example.shop.dto.request.CartItemsRequest;
import com.example.shop.entity.CartItem;
import com.example.shop.repository.CartItemRepository;
import com.example.shop.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItemsDto getCartItemsById(Long id) {
        CartItem cartItem =cartItemRepository.getCartItemById(id);
         return CartItemsDto.builder()
                 .quantity(cartItem.getQuantity())
                 .creationtime((LocalDateTime) cartItem.getCreationtime())
                 .updatetime((LocalDateTime) cartItem.getUpdatetime())

                .build();

    }

    @Override
    public void updateCartItems(CartItemsRequest cartItemsRequest) {
        CartItem cartItem =CartItem.builder()
                .id(cartItemsRequest.getId())
                .quantity(cartItemsRequest.getQuantity())
                .creationtime((LocalDateTime) cartItemsRequest.getCreationtime())
                .updatetime((LocalDateTime) cartItemsRequest.getUpdatetime())
                .shoppingSesionid(cartItemsRequest.getShoppingSesionid())
                .product(cartItemsRequest.getProduct())
                .build();

    }

    @Override
    public void saveCartItems(CartItemsRequest cartItemsRequest) {
        CartItem cartItem=CartItem.builder()
                .quantity(cartItemsRequest.getQuantity())
                .creationtime((LocalDateTime) cartItemsRequest.getCreationtime())
                .updatetime((LocalDateTime) cartItemsRequest.getUpdatetime())
                .shoppingSesionid(cartItemsRequest.getShoppingSesionid())
                .product(cartItemsRequest.getProduct())
                .build();

    }

    @Override
    public void deleteCartItemsById(Long id) {
        CartItem cartItem =cartItemRepository.getCartItemById(id);
        if (cartItem==(null)){
           throw new RuntimeException("Bele Sebet Tapilmadi");

        }else {
            cartItemRepository.deleteById(id);
        }

    }

    @Override
    public List<CartItemsDto> getAll() {
        List<CartItem> cartItems=cartItemRepository.findAll();
        List<CartItemsDto>cartItemsDtos= new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            CartItemsDto cartItemsDto = CartItemsDto.builder()
                    .quantity(cartItem.getQuantity())
                    .creationtime((LocalDateTime) cartItem.getCreationtime())
                    .updatetime((LocalDateTime) cartItem.getUpdatetime())
                    .build();
        }

        return cartItemsDtos;
    }
}
