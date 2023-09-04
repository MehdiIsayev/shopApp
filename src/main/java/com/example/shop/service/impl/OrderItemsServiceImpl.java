package com.example.shop.service.impl;


import com.example.shop.dto.OrderItemsDto;
import com.example.shop.dto.request.OrderItemsRequest;
import com.example.shop.entity.OrderItems;
import com.example.shop.repository.OrderItemsRepository;
import com.example.shop.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItemsDto getOrderItemsById(Long id) {
        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        return OrderItemsDto.builder()
                .creationtime((LocalDateTime) orderItems.getCreationtime())
                .updatetime((LocalDateTime) orderItems.getUpdatetime())
                .build();
    }

    @Override
    public void updateOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .id(orderItemsRequest.getId())
                .orderDetail(orderItemsRequest.getOrderDetail())
                .product(orderItemsRequest.getProduct())
                .creationtime((LocalDateTime) orderItemsRequest.getCreationtime())
                .updatetime((LocalDateTime) orderItemsRequest.getUpdatetime())
                .build();

    }

    @Override
    public void saveOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .orderDetail(orderItemsRequest.getOrderDetail())
                .product(orderItemsRequest.getProduct())
                .creationtime((LocalDateTime) orderItemsRequest.getCreationtime())
                .updatetime((LocalDateTime) orderItemsRequest.getUpdatetime())
                .build();

    }

    @Override
    public void deleteOrderItemsById(Long id) {
        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        if (orderItems == (null)) {
            throw new RuntimeException("Bele Sifaris Tapilmadi");

        } else {
            orderItemsRepository.getOrderItemsById(id);
        }

    }

    @Override
    public List<OrderItemsDto> getAll() {
        List<OrderItems> orderItems = orderItemsRepository.findAll();
        List<OrderItemsDto> orderItemsDtos = new ArrayList<>();
        for (OrderItems orderItems1 : orderItems) {
            OrderItemsDto orderItemsDto = OrderItemsDto.builder()

                    .creationtime((LocalDateTime) orderItems1.getCreationtime())
                    .updatetime((LocalDateTime) orderItems1.getUpdatetime())
                    .build();
        }
        return orderItemsDtos;
    }
}

