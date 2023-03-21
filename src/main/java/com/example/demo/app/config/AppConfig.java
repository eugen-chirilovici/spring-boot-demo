package com.example.demo.app.config;

import com.example.demo.app.config.model.ProductProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.demo.app.config"})
@EnableConfigurationProperties({PropertiesConfig.class})
public class AppConfig {

    @Bean
    public ProductProperties getProductProperties(PropertiesConfig propertiesConfig) {
        return propertiesConfig.getProduct();
    }

}