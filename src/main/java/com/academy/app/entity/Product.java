package com.academy.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseEntity {
    private String name;
    private String description;

    @OneToOne
    private ProductCategory productCategory;
    private Double price;
    private String remarkGeneral;
    private String remarkSpecial;

    public String getProductCategoryName() {
        if (productCategory != null) {
            return productCategory.getName();
        }
        return null;
    }
    public Long getProductCategoryId() {
        if (productCategory != null) {
            return productCategory.getId();
        }
        return null;
    }
}
