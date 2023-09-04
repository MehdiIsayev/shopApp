package com.example.shop.service.impl;

import com.example.shop.dto.ProductDto;
import com.example.shop.dto.request.ProductRequest;
import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
   private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ProductDto getProductById(Long id) {
        Product product=productRepository.getProductById(id);

        return ProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .sku(product.getSku())
                .category(product.getCategory())
                .price(product.getPrice())
                .creationtime((LocalDateTime) product.getCreationtime())
                .updatetime((LocalDateTime) product.getUpdatetime())
                .build();
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .sku(productRequest.getSku())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .updatetime((LocalDateTime) productRequest.getUpdatetime())
                .creationtime((LocalDateTime) productRequest.getCreationtime())
                .discount(productRequest.getDiscount())

                .build();

    }

    @Override
    public void saveProduct(ProductRequest productRequest) {
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .sku(productRequest.getSku())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .updatetime((LocalDateTime) productRequest.getUpdatetime())
                .creationtime((LocalDateTime) productRequest.getCreationtime())
                .discount(productRequest.getDiscount())
                .build();
    }

    @Override
    public void deleteProductById(Long id) {
        Product product =productRepository.getProductById(id);
        if(product==(null)){
            throw  new RuntimeException("bele mehsul yoxdu");

        }else{
            userRepository.deleteById(id);
        }

    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products=productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = ProductDto.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .sku(product.getSku())
                    .category(product.getCategory())
                    .price(product.getPrice())
                    .creationtime((LocalDateTime) product.getCreationtime())
                    .updatetime((LocalDateTime) product.getUpdatetime())
                    .build();
        }
        return productDtos;
    }
}
