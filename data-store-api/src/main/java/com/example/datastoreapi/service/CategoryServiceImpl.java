package com.example.datastoreapi.service;

import com.example.datastoreapi.entity.CategoryEntity;
import com.example.datastoreapi.entity.CategoryRepository;
import com.example.datastoreapi.model.CategoryRequest;
import com.example.datastoreapi.model.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = modelMapper.map(categoryRequest, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);

        return modelMapper.map(categoryEntity, CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = modelMapper.map(categoryRequest, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(categoryEntity, CategoryResponse.class);
    }


    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteCategoryEntitiesById(id);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return modelMapper.map(categoryRepository.getCategoryEntitiesById(id), CategoryResponse.class);
    }


}
