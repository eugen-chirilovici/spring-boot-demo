package com.example.demo.app.transformer;

import com.example.demo.app.dto.ProductDto;
import com.example.demo.app.repository.entity.ProductEntity;

import java.util.function.Function;

public class ProductTransformer {
    public static Function<ProductDto, ProductEntity> convertProductDtoToProductEntity =
            productDto -> ProductEntity.builder()
                    .name(productDto.getName())
                    .productType(productDto.getProductType())
                    .label(productDto.getLabel())
                    .build();

    public static Function<ProductEntity, ProductDto> convertProductToProductDto =
            productEntity -> ProductDto.builder()
                    .id(productEntity.getId())
                    .name(productEntity.getName())
                    .productType(productEntity.getProductType())
                    .label(productEntity.getLabel())
                    .build();
}
