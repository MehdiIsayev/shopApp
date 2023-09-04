package com.example.shop.controller;

import com.example.shop.dto.ShoppingSesionDto;
import com.example.shop.dto.request.ShoppingRequest;
import com.example.shop.service.ShoppingSesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/shoppingSesion"
)
public class ShoppingController {
final ShoppingSesionService shoppingSesionService;

@GetMapping(value = "/allShoppingSesion")
    public List<ShoppingSesionDto> getShoppingSesionInfo(){ return  shoppingSesionService.getAll();}
    @GetMapping(value = "getShoppingSesionById")
    public ShoppingSesionDto getShoppingSessionById(@PathVariable(value = "id")Long id){
    return  shoppingSesionService.getShoppingsServiceById(id);
    }
    @PostMapping(value = "/saveShoppinSesion")
    public void saveShoppinSesion(@RequestBody ShoppingRequest shoppingRequest){
    shoppingSesionService.saveShoppingSesion(shoppingRequest);
    }
    @PostMapping(value = "/updateShoppingSesion")
    public void updateShoppingSesion(@RequestBody ShoppingRequest shoppingRequest){
    shoppingSesionService.saveShoppingSesion(shoppingRequest);
    }
    @DeleteMapping(value = "/deleteShoppingSesion")
    public void delteById(@PathVariable(value = "id")Long id){
    shoppingSesionService.deleteShoppingServiceById(id);
    }
}
