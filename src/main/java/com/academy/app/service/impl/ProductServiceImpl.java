package com.academy.app.service.impl;

import com.academy.app.entity.Product;
import com.academy.app.repository.ProductRepository;
import com.academy.app.service.ProductService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(@NonNull ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByNameContains(String param) {
        return productRepository.findByNameContains(param);
    }
}
