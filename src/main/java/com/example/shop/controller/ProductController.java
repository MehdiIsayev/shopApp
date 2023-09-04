package com.example.shop.controller;


import com.example.shop.dto.ProductDto;
import com.example.shop.dto.request.ProductRequest;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {
    final  ProductService productService;
    @GetMapping(value = "/geAllProduct")
    public List<ProductDto> getAllProductInfo(){
        return productService.getAll();
    }
    @GetMapping(value = "/getProductById")
    public ProductDto getProuctById(@PathVariable(value = "id")Long id){return productService.getProductById(id);

    }
    @PostMapping(value = "/saveProduct")
    public void saveProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);

    }
    @PostMapping(value = ("/updateProduct"))
    public void updatePoduct(@RequestBody ProductRequest productRequest){
        productService.updateProduct(productRequest);
    }
    @DeleteMapping(value = "/deleteProductById/{id}")
    public  void deleteProductById(@PathVariable(value = "id") Long id){
        productService.deleteProductById(id);
    }

}
