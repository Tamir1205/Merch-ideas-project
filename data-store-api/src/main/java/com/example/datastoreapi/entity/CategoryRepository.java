package com.example.datastoreapi.entity;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity getCategoryEntitiesById(Long id);
    @Transactional
    void deleteCategoryEntitiesById(Long id);
}
