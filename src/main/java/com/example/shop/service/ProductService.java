package com.example.shop.service;

import com.example.shop.dto.ProductDto;
import com.example.shop.dto.request.ProductRequest;
import com.example.shop.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);
    void updateProduct(ProductRequest productRequest);
    void saveProduct(ProductRequest productRequest);
    void deleteProductById(Long id);
    List<ProductDto> getAll();

}
