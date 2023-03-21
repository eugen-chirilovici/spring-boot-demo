package com.example.demo.app.service;

import com.example.demo.app.dto.ProductDto;
import com.example.demo.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.app.transformer.ProductTransformer.convertProductDtoToProductEntity;
import static com.example.demo.app.transformer.ProductTransformer.convertProductToProductDto;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
//    private final TempService tempService;

    public void createProduct(String name) {
        var productDto = ProductDto.builder().name(name).build();
        var productEntity = convertProductDtoToProductEntity.apply(productDto);
        productRepository.save(productEntity);
    }

    public List<ProductDto> readAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(convertProductToProductDto)
                .toList();
    }
}
