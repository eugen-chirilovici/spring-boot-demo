package com.example.demo.app.controller;

import com.example.demo.app.dto.ProductDto;
import com.example.demo.app.dto.enums.ProductType;
import com.example.demo.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("product")
    public List<ProductDto> readAllProducts() {
        return productService.readAllProducts();
    }

    @PostMapping(value = "product")
    public ResponseEntity<String> saveProduct(@RequestParam String name, @RequestParam ProductType type) {
        productService.createProduct(name, type);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("All good");
    }
}
