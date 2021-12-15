package com.example.softuniexam.service.impl;

import com.example.softuniexam.model.entity.Category;
import com.example.softuniexam.model.entity.enums.CategoryNameEnum;
import com.example.softuniexam.repository.CategoryRepository;
import com.example.softuniexam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category(categoryNameEnum,
                                "Description for " + categoryNameEnum.name());

                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}