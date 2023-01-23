package com.academy.app.repository;

import com.academy.app.entity.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends BaseRepo<ProductCategory> {
    Optional<ProductCategory> getByName(String name);
}
