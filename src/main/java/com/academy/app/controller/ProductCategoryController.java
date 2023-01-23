package com.academy.app.controller;


import com.academy.app.dto.ProductCategoryDto;
import com.academy.app.dto.converter.ProductCategoryConverter;
import com.academy.app.entity.ProductCategory;
import com.academy.app.service.ProductCategoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class ProductCategoryController {

    @NonNull
    private ProductCategoryService categoriesService;

    @NonNull
    private ProductCategoryConverter converter;

    @PostMapping()
    public String addProduct(
            ProductCategoryDto categoryDto
    ) {
        ProductCategory product = converter.getEntity(categoryDto);
        categoriesService.saveOrUpdate(product);

        return "redirect:/api/products";
    }

    @GetMapping()
    public String getCategories(
            Model model
    ) {
        List<ProductCategory> categories = categoriesService.findAll();
        List<ProductCategoryDto> categoriesDto = converter.getDtoList(categories);
        model.addAttribute("categories", categoriesDto);

        return "category/category_list";
    }

    @GetMapping("/{id}")
    public String getProduct(
            @PathVariable Long id, Model model
    ) {
        ProductCategory product = categoriesService.findById(id);
        ProductCategoryDto dto = converter.getDto(product);
        model.addAttribute("category", dto);
        return "category/category_item";
    }

    @PostMapping("/delete")
    public String deleteProduct(
            Long id,
            Model model
    ) {
        categoriesService.deleteById(id);
        return "redirect:/api/categories";
    }
}

