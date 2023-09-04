package com.example.shop.service;

import com.example.shop.dto.OrderDetailDto;
import com.example.shop.dto.OrderItemsDto;
import com.example.shop.dto.request.OrderItemsRequest;

import java.util.List;

public interface OrderItemsService {
    OrderItemsDto getOrderItemsById(Long id);
    void updateOrderItems(OrderItemsRequest orderItemsRequest);
    void saveOrderItems(OrderItemsRequest orderItemsRequest);
    void deleteOrderItemsById(Long id);
    List<OrderItemsDto> getAll();

}
