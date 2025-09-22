package com.ecommerce.anshul.repositories;

import com.ecommerce.anshul.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
