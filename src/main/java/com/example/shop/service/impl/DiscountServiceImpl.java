package com.example.shop.service.impl;

import com.example.shop.dto.DiscountDto;
import com.example.shop.dto.request.DiscountRequest;
import com.example.shop.entity.Discount;
import com.example.shop.repository.DiscountRepository;
import com.example.shop.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;

    @Override
    public DiscountDto getDiscountById(Long id) {
        Discount discount=discountRepository.getDiscountById(id);

        return DiscountDto.builder()
                .name(discount.getName())
                .description(discount.getDescription())
                .discountprosentage(discount.getDiscountprosentage())
                .creationtime((LocalDateTime) discount.getCreationtime())
                .updatetime((LocalDateTime) discount.getUpdatetime())
                .build();
    }

    @Override
    public void updateDiscount(DiscountRequest discountRequest) {
        Discount discount=Discount.builder()
                .id(discountRequest.getId())
                .name(discountRequest.getName())
                .description(discountRequest.getDescription())
                .discountprosentage(discountRequest.getDiscountprosentage())
                .creationtime((LocalDateTime) discountRequest.getCreationtime())
                .updatetime((LocalDateTime) discountRequest.getUpdatetime())

                .build();

    }

    @Override
    public void saveDiscount(DiscountRequest discountRequest) {
        Discount discount=Discount.builder()
                .name(discountRequest.getName())
                .description(discountRequest.getDescription())
                .discountprosentage(discountRequest.getDiscountprosentage())
                .creationtime((LocalDateTime) discountRequest.getCreationtime())
                .updatetime((LocalDateTime) discountRequest.getUpdatetime())

                .build();

    }

    @Override
    public void deleteDiscountById(Long id) {
        Discount discount=discountRepository.getDiscountById(id);
        if (discount==(null)){
            throw new RuntimeException("Bele endirim tapilmadi");
        }else {
            discountRepository.getDiscountById(id);
        }

    }

    @Override
    public List<DiscountDto> getAll() {
        List<Discount> discounts=discountRepository.findAll();
        List<DiscountDto>discountDtos= new ArrayList<>();
        for (Discount discount : discounts) {
        DiscountDto discountDto = DiscountDto.builder()
                    .name(discount.getName())
                    .description(discount.getDescription())
                    .discountprosentage(discount.getDiscountprosentage())
                    .creationtime((LocalDateTime) discount.getCreationtime())
                    .updatetime((LocalDateTime) discount.getUpdatetime())
                .build();
    }
        return null;
    }
}
