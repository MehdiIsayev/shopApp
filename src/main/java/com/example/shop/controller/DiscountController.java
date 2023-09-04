package com.example.shop.controller;

import com.example.shop.dto.DiscountDto;
import com.example.shop.dto.request.DiscountRequest;
import com.example.shop.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/discount")
@RequiredArgsConstructor
public class DiscountController {
    final DiscountService discountService;
    @GetMapping(value = "/getAllDiscount")
    public List<DiscountDto> getAllDiscountInfo(){
        return discountService.getAll();
    }
    @GetMapping(value = "/getDiscountById")
    public DiscountDto getDiscountById(@PathVariable (value = "id")Long id){
        return discountService.getDiscountById(id);

    }
    @PostMapping(value = "/saveDiscount")
    public void saveDiscount(@RequestBody DiscountRequest discountRequest){
        discountService.saveDiscount(discountRequest);
    }
    @PostMapping(value = "/updateDiscount")
    public void updateDiscount(@RequestBody DiscountRequest discountRequest){
        discountService.updateDiscount(discountRequest);
    }
    @DeleteMapping(value = "/deleteDiscount/{id}")
    public void deleteDiscount(@PathVariable(value = "id")Long id){
        discountService.deleteDiscountById(id);
    }
}
