package com.example.demo.app.utils;

import com.example.demo.app.config.model.ProductProperties;
import com.example.demo.app.dto.enums.ProductType;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductUtils {

    public static String findProductLabel(List<ProductProperties.Pair> pairs, ProductType type) {
        return pairs.stream()
                .filter(pair -> pair.getType().equalsIgnoreCase(type.name()))
                .map(ProductProperties.Pair::getLabel)
                .findFirst()
                .orElseThrow();
    }
}
