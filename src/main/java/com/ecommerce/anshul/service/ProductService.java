package com.ecommerce.anshul.service;

import com.ecommerce.anshul.model.Product;
import com.ecommerce.anshul.payload.ProductDTO;
import com.ecommerce.anshul.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();
}
