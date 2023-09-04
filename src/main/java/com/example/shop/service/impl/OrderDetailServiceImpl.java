package com.example.shop.service.impl;

import com.example.shop.dto.OrderDetailDto;
import com.example.shop.dto.request.OrderDetailRequest;
import com.example.shop.entity.OrderDetail;
import com.example.shop.repository.OrderDetailRepository;
import com.example.shop.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
   private final OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDetailDto getOrderDetailsById(Long id) {
        OrderDetail orderDetail= orderDetailRepository.getOrderDetailById(id);

        return OrderDetailDto.builder()
                .total(orderDetail.getTotal())
                .creationtime((LocalDateTime) orderDetail.getCreationtime())
                .updatetime((LocalDateTime) orderDetail.getUpdatetime())

                .build();
    }

    @Override
    public void updateOrderDetails(OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail=OrderDetail.builder()
                .id(orderDetailRequest.getId())
                .total(orderDetailRequest.getTotal())
                .creationtime((LocalDateTime) orderDetailRequest.getCreationtime())
                .updatetime((LocalDateTime) orderDetailRequest.getUpdatetime())
                .userid(orderDetailRequest.getUserid())
                .paymentDetail(orderDetailRequest.getPaymentDetail())
                .build();

    }

    @Override
    public void saveOrderDetails(OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail=OrderDetail.builder()
                .total(orderDetailRequest.getTotal())
                .creationtime((LocalDateTime) orderDetailRequest.getCreationtime())
                .updatetime((LocalDateTime) orderDetailRequest.getUpdatetime())
                .userid(orderDetailRequest.getUserid())
                .paymentDetail(orderDetailRequest.getPaymentDetail())
                .build();

    }

    @Override
    public void deleteOrderDetailsById(Long id) {
        OrderDetail orderDetail=orderDetailRepository.getOrderDetailById(id);
        if (orderDetail==(null)){
            throw new RuntimeException("Bele sifaris melumatlari tapilmadi");
        }else {
            orderDetailRepository.deleteById(id);
        }

    }

    @Override
    public List<OrderDetailDto> getAll() {
        List<OrderDetail> orderDetails=orderDetailRepository.findAll();
        List<OrderDetailDto>orderDetailDtos=new ArrayList<>();
        for (OrderDetail orderDetail:orderDetails){
            OrderDetailDto orderDetailDto =OrderDetailDto.builder()
                    .total(orderDetail.getTotal())
                    .creationtime((LocalDateTime) orderDetail.getCreationtime())
                    .updatetime((LocalDateTime) orderDetail.getUpdatetime())
                    .build();
        }
        return null;
    }
}
