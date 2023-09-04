package com.example.shop.service;

import com.example.shop.dto.PaymentDetailDto;

import com.example.shop.dto.request.PaymentDetailRequest;
import com.example.shop.entity.PaymentDetail;

import java.util.List;

public interface PaymentDetailService {
    PaymentDetailDto getPaymentDetailByid(Long id);
    void updatePaymentDetail(PaymentDetailRequest paymentDetailRequest);
    void savePaymentDetail(PaymentDetailRequest paymentDetailRequest);
    void deletePaymentDetailById(Long id);
    List<PaymentDetailDto> getAll();
}
