package com.ecommerce.anshul.service;

import com.ecommerce.anshul.exceptions.APIException;
import com.ecommerce.anshul.exceptions.ResourceNotFoundException;
import com.ecommerce.anshul.model.Category;
import com.ecommerce.anshul.payload.CategoryDTO;
import com.ecommerce.anshul.payload.CategoryResponse;
import com.ecommerce.anshul.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    //private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("No category created till now.");
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++) ;
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null)
            throw new APIException("Category with the name: " + category.getCategoryName() +" already exists.");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category with categoryId: "+ categoryId + " deleted successfully!!";
//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                 .filter(c -> c.getCategoryId().equals(categoryId))
//                 .findFirst()
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found") );
//         categoryRepository.delete(category);
//         return "Category with categoryId: "+ categoryId + " deleted successfully!!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
//        List<Category> categories = categoryRepository.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst() ;
//        if(optionalCategory.isPresent()) {
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//
//            Category savedCategory = categoryRepository.save(existingCategory);
//            return savedCategory;
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
//        }
    }
}
