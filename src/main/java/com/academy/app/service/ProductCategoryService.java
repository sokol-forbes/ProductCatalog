package com.academy.app.service;

import com.academy.app.entity.ProductCategory;

public interface ProductCategoryService extends CrudOperations<ProductCategory> {
    ProductCategory getByName(String name);
    void deleteById(Long id);
}
