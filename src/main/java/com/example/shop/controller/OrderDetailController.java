package com.example.shop.controller;

import com.example.shop.dto.OrderDetailDto;
import com.example.shop.dto.request.OrderDetailRequest;
import com.example.shop.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderDetail")
@RequiredArgsConstructor
public class OrderDetailController {
    final OrderDetailService orderDetailService;
    @GetMapping(value = "/allOrderDetail")
    public List<OrderDetailDto> getAllOrderDetailInfo(){
        return orderDetailService.getAll();
    }
    @GetMapping(value = "/getOrderDetailById")
    public OrderDetailDto getOrderDetailById(@PathVariable(value = "id")Long id){
        return orderDetailService.getOrderDetailsById(id);

    }
    @PostMapping(value = "/saveOrderDetail")
    public void saveOrderDetail(@RequestBody OrderDetailRequest orderDetailRequest){
        orderDetailService.saveOrderDetails(orderDetailRequest);
    }
    @PostMapping(value = "/updateOrderDetails")
    public void updateOrderDetail(@RequestBody OrderDetailRequest orderDetailRequest){
        orderDetailService.updateOrderDetails(orderDetailRequest);
    }
    @DeleteMapping(value = "/deletedeOrderDetail/{id}")
    public void deleteOrderDetails(@PathVariable(value = "id")Long id){
        orderDetailService.deleteOrderDetailsById(id);
    }
}
