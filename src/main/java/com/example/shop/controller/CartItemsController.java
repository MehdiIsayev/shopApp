package com.example.shop.controller;

import com.example.shop.dto.CartItemsDto;
import com.example.shop.dto.request.CartItemsRequest;
import com.example.shop.entity.CartItem;
import com.example.shop.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/cartItems")
@RequiredArgsConstructor
public class CartItemsController {
    final CartItemService cartItemService;
    @GetMapping(value = "/allCartItems")
    public List<CartItemsDto> getAllCartItemsInfo(){
        return cartItemService.getAll();

    }
    @GetMapping(value = "getCartItemsById")
    public CartItemsDto getCartItemsById(@PathVariable(value = "id")Long id){
        return cartItemService.getCartItemsById(id);
    }
    @PostMapping(value = "/saveCartItems")
    public void saveCartItems(@RequestBody CartItemsRequest cartItemsRequest){
        cartItemService.saveCartItems(cartItemsRequest);
    }
    @PostMapping(value = "/updateCartItems")
    public void updateCartItems(@RequestBody CartItemsRequest cartItemsRequest){
        cartItemService.updateCartItems(cartItemsRequest);

    }
    @DeleteMapping(value = "/deleteCartItems")
        public void deleteCartItems(@PathVariable(value = "id") Long id){
               cartItemService.deleteCartItemsById(id);
        }

}
