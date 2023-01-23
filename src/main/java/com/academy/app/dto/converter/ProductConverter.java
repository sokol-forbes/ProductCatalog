package com.academy.app.dto.converter;

import com.academy.app.dto.ProductDto;
import com.academy.app.entity.Product;

public class ProductConverter implements EntityConverter<Product, ProductDto>{
    @Override
    public ProductDto getDto(Product entity) {
        return ProductDto.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .productCategory(entity.getProductCategory())
                .price(entity.getPrice())
                .remarkGeneral(entity.getRemarkGeneral())
                .remarkSpecial(entity.getRemarkSpecial())
                .build();
    }

    @Override
    public Product getEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setRemarkGeneral(dto.getRemarkGeneral());
        product.setRemarkSpecial(dto.getRemarkSpecial());
        product.setDeleted(false);

        return product;
    }
}
