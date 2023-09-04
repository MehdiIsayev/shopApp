package com.example.shop.controller;

import com.example.shop.dto.PaymentDetailDto;
import com.example.shop.dto.request.PaymentDetailRequest;
import com.example.shop.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/paymentDetail")
@RestController

public class PaymentDetailController {
    final PaymentDetailService paymentDetailService;
    @GetMapping(value = "/getAllPaymentDetai")
    public List<PaymentDetailDto>getPaymentDetailInfo(){return paymentDetailService.getAll();}
    @GetMapping(value = "/getpaymentDetailById")
    public PaymentDetailDto getPaymentDetailById(@PathVariable(value = "id")Long id){return  paymentDetailService.getPaymentDetailByid(id);}
    @PostMapping(value = "/savepaymentDetail")
    public void savepaymentDetail(@RequestBody PaymentDetailRequest paymentDetailRequest){
        paymentDetailService.savePaymentDetail(paymentDetailRequest);
    }
    @PostMapping (value = "/updatePaymentDetail")
    public void updatePaymentDetail(@RequestBody PaymentDetailRequest paymentDetailRequest){
        paymentDetailService.updatePaymentDetail(paymentDetailRequest);
    }
    @DeleteMapping(value = "/deletePaymentdetail/{id}")
    public void deletePaymentDetail(@PathVariable(value = "id")Long id){
        paymentDetailService.deletePaymentDetailById(id);
    }
}
