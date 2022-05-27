package com.example.datastoreapi.service;

import com.example.datastoreapi.model.CategoryRequest;
import com.example.datastoreapi.model.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(CategoryRequest categoryRequest);
    void deleteCategoryById(Long id);
    CategoryResponse getCategoryById(Long id);
}
