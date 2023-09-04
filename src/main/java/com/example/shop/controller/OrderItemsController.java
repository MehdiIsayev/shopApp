package com.example.shop.controller;

import com.example.shop.dto.OrderItemsDto;
import com.example.shop.dto.request.OrderItemsRequest;
import com.example.shop.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/orderItems")
@RestController
@RequiredArgsConstructor
public class OrderItemsController {
    final OrderItemsService orderItemsService;

    @GetMapping(value = "/allorderItems")
    public List<OrderItemsDto> getAllOrderItemsInfo(){
        return orderItemsService.getAll();
    }
    @GetMapping(value = "/getOrderItemsById")
    public OrderItemsDto getOrderItemsById(@PathVariable(value = "id")Long id){
        return orderItemsService.getOrderItemsById(id);
    };
    @PostMapping(value = "/saveOrderItems")
    public void saveOrderItems(@RequestBody OrderItemsRequest orderItemsRequest){
        orderItemsService.saveOrderItems(orderItemsRequest);
    }
    @PostMapping(value = "/updateOrderItems")
    public void updateOrderItems(@RequestBody OrderItemsRequest orderItemsRequest){
        orderItemsService.updateOrderItems(orderItemsRequest);
    }
    @DeleteMapping(value = "/deleteOrderItems/{id}")
    public void deleteOrderItems(@PathVariable(value = "id")Long id){
        orderItemsService.deleteOrderItemsById(id);
    }
}
