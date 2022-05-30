package com.example.datastoreapi.controller;

import com.example.datastoreapi.entity.CategoryRepository;
import com.example.datastoreapi.model.CategoryRequest;
import com.example.datastoreapi.model.CategoryResponse;
import com.example.datastoreapi.model.MerchDTO;
import com.example.datastoreapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
    @PutMapping
    CategoryResponse updateCategory(@RequestParam String brandName, CategoryRequest categoryRequest){
        return categoryService.updateCategory(categoryRequest);
    }
    @GetMapping
    CategoryResponse getCategoryById(@RequestParam Long id){
        return categoryService.getCategoryById(id);
    }
    @DeleteMapping
    String deleteCategory(@RequestParam Long id){
         categoryService.deleteCategoryById(id);
         return "Category successfully deleted";
    }



}
