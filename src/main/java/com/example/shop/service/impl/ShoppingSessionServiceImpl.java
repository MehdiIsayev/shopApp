package com.example.shop.service.impl;

import com.example.shop.dto.ShoppingSesionDto;
import com.example.shop.dto.request.ShoppingRequest;
import com.example.shop.entity.ShoppingSesion;
import com.example.shop.repository.ShoppingSesionRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.ShoppingSesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingSessionServiceImpl implements ShoppingSesionService {
    private final ShoppingSesionRepository shoppingSesionRepository;
    private final UserRepository userRepository;

    @Override
    public ShoppingSesionDto getShoppingsServiceById(Long id) {
        ShoppingSesion shoppingSesion = shoppingSesionRepository.getShoppingSesionById(id);
        return  ShoppingSesionDto.builder()
                .total(shoppingSesion.getTotal())
                .creationtime((LocalDateTime) shoppingSesion.getCreationtime())
                .updatetime((LocalDateTime) shoppingSesion.getUpdatetime())
                .build();
    }

    @Override
    public void updateShoppingSesion(ShoppingRequest shoppingRequest) {
        ShoppingSesion shoppingSesion=ShoppingSesion.builder()
                .id(shoppingRequest.getId())
                .total(shoppingRequest.getTotal())
                .creationtime((LocalDateTime)shoppingRequest.getCreationtime() )
                .updatetime((LocalDateTime) shoppingRequest.getUpdatetime())
                .userid(shoppingRequest.getUserid())
                .build();


    }

    @Override
    public void saveShoppingSesion(ShoppingRequest shoppingRequest) {
        ShoppingSesion shoppingSesion =ShoppingSesion.builder()
                .userid(shoppingRequest.getUserid())
                .total(shoppingRequest.getTotal())
                .updatetime((LocalDateTime) shoppingRequest.getUpdatetime())
                .creationtime((LocalDateTime) shoppingRequest.getCreationtime())



                .build();

    }






    @Override
    public void deleteShoppingServiceById(Long id) {
        ShoppingSesion shoppingSesion= shoppingSesionRepository.getShoppingSesionById(id);
        if (shoppingSesion==(null)){
            throw new RuntimeException("Bele id yoxdu");
        }else {
            userRepository.deleteById(id);
        }

    }

    @Override
    public List<ShoppingSesionDto> getAll() {
        List<ShoppingSesion> shoppingSesions=shoppingSesionRepository.findAll();
        List<ShoppingSesionDto>shoppingSesionDtos=new ArrayList<>();
        for (ShoppingSesion shoppingSesion : shoppingSesions) {
            ShoppingSesionDto shoppingSesionDto = ShoppingSesionDto.builder()
                    .total(shoppingSesion.getTotal())
                    .creationtime((LocalDateTime) shoppingSesion.getCreationtime())
                    .updatetime((LocalDateTime) shoppingSesion.getUpdatetime())
                    .build();
        }
        return shoppingSesionDtos;
    }
}
