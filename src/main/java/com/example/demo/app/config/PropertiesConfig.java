package com.example.demo.app.config;

import com.example.demo.app.config.model.ProductProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "service")
@NoArgsConstructor
public class PropertiesConfig {

    @NestedConfigurationProperty
    private ProductProperties product;

}
