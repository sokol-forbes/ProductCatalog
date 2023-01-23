package com.academy.app.controller;



import com.academy.app.dto.ProductDto;
import com.academy.app.dto.converter.ProductConverter;
import com.academy.app.entity.Product;
import com.academy.app.entity.ProductCategory;
import com.academy.app.service.ProductCategoryService;
import com.academy.app.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class CatalogController {

    @NonNull
    private ProductService productService;

    @NonNull
    private ProductCategoryService categoriesService;

    @NonNull
    private ProductConverter productConverter;


    @PostMapping()
    public String addProduct(
            ProductDto productDto
    ) {
        Product product = productConverter.getEntity(productDto);
        Long id = productDto.getProductCategoryId();
        if (id != null) {
            ProductCategory category = categoriesService.findById(id);
            product.setProductCategory(category);
            productService.saveOrUpdate(product);
        }

        return "redirect:/api/products";
    }

    @GetMapping()
    public String getCatalog(
            @RequestParam(required = false, defaultValue = "false") boolean isDelete,
            @RequestParam(required = false, defaultValue = "") String searchQuery,
            @RequestParam(required = false, defaultValue = "") String categoryName,
            Model model
    ) {
        List<Product> catalog = null;
        if (searchQuery.isBlank()) {
            catalog = productService.findAll();
        } else {
            catalog = productService.findByNameContains(searchQuery);
        }

        if (!categoryName.isBlank()) {
            ProductCategory category = categoriesService.getByName(categoryName);
            catalog = catalog.stream()
                    .filter(product -> product.getProductCategory().getId().equals(category.getId()))
                    .collect(Collectors.toList());
        }

        List<ProductCategory> categories = categoriesService.findAll();
        List<ProductDto> catalogDto = productConverter.getDtoList(catalog);

        model.addAttribute("searchQuery", searchQuery);
        model.addAttribute("products", catalog);
        model.addAttribute("categories", categories);

        return "catalog/catalog";
    }

    @GetMapping("/{id}")
    public String getProduct(
            @PathVariable Long id, Model model
    ) {
        Product product = productService.findById(id);
        List<ProductCategory> categories = categoriesService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "catalog/product_page";
    }

    @PostMapping("/delete")
    public String deleteProduct(
            Long id,
            Model model
    ) {
        productService.deleteById(id);
        return "redirect:/api/products?deleted=" + "true";
    }
}

