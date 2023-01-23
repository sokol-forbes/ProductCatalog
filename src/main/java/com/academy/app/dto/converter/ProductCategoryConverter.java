package com.academy.app.dto.converter;


import com.academy.app.dto.ProductCategoryDto;
import com.academy.app.entity.ProductCategory;

public class ProductCategoryConverter implements EntityConverter<ProductCategory, ProductCategoryDto>{
    @Override
    public ProductCategoryDto getDto(ProductCategory entity) {
        return ProductCategoryDto.builder()
                .name(entity.getName())
                .id(entity.getId())
                .build();
    }

    @Override
    public ProductCategory getEntity(ProductCategoryDto dto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.getName());
        productCategory.setId(dto.getId());

        return productCategory;
    }
}

