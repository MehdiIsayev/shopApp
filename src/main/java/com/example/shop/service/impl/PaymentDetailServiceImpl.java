package com.example.shop.service.impl;

import com.example.shop.dto.PaymentDetailDto;
import com.example.shop.dto.request.PaymentDetailRequest;
import com.example.shop.entity.PaymentDetail;
import com.example.shop.repository.PaymentDetailRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl  implements PaymentDetailService {

    private final PaymentDetailRepository paymentDetailRepository;
    private final UserRepository userRepository;

    @Override
    public PaymentDetailDto getPaymentDetailByid(Long id) {
        PaymentDetail paymentDetail = paymentDetailRepository.getPaymentDetailById(id);

        return PaymentDetailDto.builder()
                .amount(paymentDetail.getAmount())
                .provider(paymentDetail.getProvider())
                .status(paymentDetail.getStatus())
                .creationtime((LocalDateTime) paymentDetail.getCreationtime())
                .updatetime((LocalDateTime) paymentDetail.getUpdatetime())

                .build();
    }

    @Override
    public void updatePaymentDetail(PaymentDetailRequest paymentDetailRequest) {
        PaymentDetail paymentDetail=PaymentDetail.builder()
                .id(paymentDetailRequest.getId())
                .amount(paymentDetailRequest.getAmount())
                .provider(paymentDetailRequest.getProvider())
                .status(paymentDetailRequest.getStatus())
                .creationtime((LocalDateTime) paymentDetailRequest.getCreationtime())
                .updatetime((LocalDateTime) paymentDetailRequest.getUpdatetime())
                .orderDetail(paymentDetailRequest.getOrderDetail())
                .build();

    }

    @Override
    public void savePaymentDetail(PaymentDetailRequest paymentDetailRequest) {
     PaymentDetail paymentDetail = PaymentDetail.builder()
             .amount(paymentDetailRequest.getAmount())
             .provider(paymentDetailRequest.getProvider())
             .status(paymentDetailRequest.getStatus())
             .creationtime((LocalDateTime) paymentDetailRequest.getCreationtime())
             .updatetime((LocalDateTime) paymentDetailRequest.getUpdatetime())
             .orderDetail(paymentDetailRequest.getOrderDetail())
             .build();
    }

    @Override
    public void deletePaymentDetailById(Long id) {
     PaymentDetail paymentDetail=paymentDetailRepository.getPaymentDetailById(id);
     if(paymentDetail==(null))
     {
         throw new RuntimeException("Bele emeliyyat tapilmadi");
     }else {
         paymentDetailRepository.deleteById(id);
     }
    }

    @Override
    public List<PaymentDetailDto> getAll() {
        List<PaymentDetail> paymentDetails=paymentDetailRepository.findAll();
        List<PaymentDetailDto>paymentDetailDtos= new ArrayList<>();
        for (PaymentDetail paymentDetail : paymentDetails) {
            PaymentDetailDto paymentDetailDto = PaymentDetailDto.builder()
                    .amount(paymentDetail.getAmount())
                    .provider(paymentDetail.getProvider())
                    .status(paymentDetail.getStatus())
                    .creationtime((LocalDateTime) paymentDetail.getCreationtime())
                    .updatetime((LocalDateTime) paymentDetail.getUpdatetime())
                    .build();
        }
        return paymentDetailDtos;
    }
}
