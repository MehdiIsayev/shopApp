package com.example.shop.service;

import com.example.shop.dto.OrderDetailDto;
import com.example.shop.dto.request.OrderDetailRequest;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto getOrderDetailsById(Long id);
    void updateOrderDetails(OrderDetailRequest orderDetailRequest);
    void saveOrderDetails(OrderDetailRequest orderDetailRequest);
    void deleteOrderDetailsById(Long id);
    List<OrderDetailDto> getAll();

}
