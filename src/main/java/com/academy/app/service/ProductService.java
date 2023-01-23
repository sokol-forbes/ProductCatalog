package com.academy.app.service;

import com.academy.app.entity.Product;

import java.util.List;

public interface ProductService extends CrudOperations<Product> {
    List<Product> findByNameContains(String param);
}
