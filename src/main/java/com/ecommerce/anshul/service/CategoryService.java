package com.ecommerce.anshul.service;

import com.ecommerce.anshul.model.Category;
import com.ecommerce.anshul.payload.CategoryDTO;
import com.ecommerce.anshul.payload.CategoryResponse;


public interface CategoryService {
    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
