package com.ecommerce.anshul.repositories;

import com.ecommerce.anshul.model.Category;
import com.ecommerce.anshul.payload.CategoryDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);

}
