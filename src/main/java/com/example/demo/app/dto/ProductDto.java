package com.example.demo.app.dto;

import com.example.demo.app.dto.enums.ProductType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDto {
    long id;
    String name;
    ProductType productType;
    String label;
}
