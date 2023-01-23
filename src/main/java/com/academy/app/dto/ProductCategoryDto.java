package com.academy.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryDto {
    private Long id;
    private String name;
}
