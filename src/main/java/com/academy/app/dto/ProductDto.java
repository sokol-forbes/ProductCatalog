package com.academy.app.dto;

import com.academy.app.entity.ProductCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private ProductCategory productCategory;
    private Long productCategoryId;
    private Double price;
    private String remarkGeneral;
    private String remarkSpecial;
}
