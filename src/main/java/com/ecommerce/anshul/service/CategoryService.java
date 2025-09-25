package com.ecommerce.anshul.service;

import com.ecommerce.anshul.model.Category;
import com.ecommerce.anshul.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
   CategoryResponse getAllCategories();
   void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
