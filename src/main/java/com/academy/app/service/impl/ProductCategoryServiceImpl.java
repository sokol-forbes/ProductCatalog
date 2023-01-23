package com.academy.app.service.impl;

import com.academy.app.entity.Product;
import com.academy.app.entity.ProductCategory;
import com.academy.app.exception.NotFoundException;
import com.academy.app.repository.BaseRepo;
import com.academy.app.repository.ProductCategoryRepository;
import com.academy.app.repository.ProductRepository;
import com.academy.app.service.ProductCategoryService;
import lombok.NonNull;

import javax.transaction.Transactional;
import java.util.List;

public class ProductCategoryServiceImpl extends GenericServiceImpl<ProductCategory> implements ProductCategoryService {
    private final ProductRepository productRepository;

    public ProductCategoryServiceImpl(
            @NonNull BaseRepo<ProductCategory> productCategoryRepository,
            @NonNull ProductRepository productRepository
    ){
        super(productCategoryRepository);
        this.productRepository = productRepository;
    }
    @Override
    public ProductCategory getByName(String name) {
        ProductCategoryRepository service = (ProductCategoryRepository) repository;
        return ((ProductCategoryRepository) repository).getByName(name)
                .orElseThrow(() -> new NotFoundException("Not existing name: " + name));
    }
    @Override
    @Transactional
    public void deleteById(Long id) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            product.setProductCategory(null);
        }
        productRepository.saveAll(products);
        repository.deleteById(id);
    }
}
