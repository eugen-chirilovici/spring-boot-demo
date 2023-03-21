package com.example.demo.app.config.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductProperties {

    @NestedConfigurationProperty
    private List<Pair> pairs;

    @Data
    @NoArgsConstructor
    public static class Pair {
        private String type;
        private String label;
    }
}
