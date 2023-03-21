package com.example.demo.app.service;

import com.example.demo.app.config.model.ProductProperties;
import com.example.demo.app.dto.ProductDto;
import com.example.demo.app.dto.enums.ProductType;
import com.example.demo.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.app.transformer.ProductTransformer.convertProductDtoToProductEntity;
import static com.example.demo.app.transformer.ProductTransformer.convertProductToProductDto;
import static com.example.demo.app.utils.ProductUtils.findProductLabel;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductProperties productProperties;

    @Value("${service.system.time}")
    private Long sleepTime;

    public void createProduct(String name, ProductType productType) {
        var productDto = ProductDto.builder()
                .name(name)
                .productType(productType)
                .label(findProductLabel(productProperties.getPairs(), productType))
                .build();
        var productEntity = convertProductDtoToProductEntity.apply(productDto);
        productRepository.save(productEntity);
    }

    public List<ProductDto> readAllProducts() {

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return productRepository.findAll()
                .stream()
                .map(convertProductToProductDto)
                .toList();
    }
}
