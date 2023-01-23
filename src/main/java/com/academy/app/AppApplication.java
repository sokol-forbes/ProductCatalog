package com.academy.app;

import com.academy.app.dto.converter.ProductCategoryConverter;
import com.academy.app.dto.converter.ProductConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {
    public static void main(String[] args)  {

        SpringApplication.run(AppApplication.class, args);


    }
    @Bean
    public ProductConverter createProductConverter() {
        return new ProductConverter();
    }

    @Bean
    public ProductCategoryConverter createProductCategoryConverter() {
        return new ProductCategoryConverter();
    }
}
