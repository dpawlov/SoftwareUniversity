package com.example.examprep1.service.impl;

import com.example.examprep1.model.entity.Category;
import com.example.examprep1.model.entity.CategoryNameEnum;
import com.example.examprep1.repository.CategoryRepository;
import com.example.examprep1.service.CategoryService;
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
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);

                    switch (categoryNameEnum) {
                        case CAKE: category.setNeededTime(10);break;
                        case DRINK:category.setNeededTime(1);break;
                        case COFFEE:category.setNeededTime(2);break;
                        case OTHER:category.setNeededTime(5);break;
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
