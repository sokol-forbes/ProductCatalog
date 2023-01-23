package com.academy.app.repository;

import com.academy.app.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepo<Product> {
    List<Product> findByNameContains(String param);
}
