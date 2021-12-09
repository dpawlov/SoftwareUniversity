package com.example.examprep3.service.impl;

import com.example.examprep3.model.entity.Category;
import com.example.examprep3.model.enums.CategoryName;
import com.example.examprep3.repository.CategoryRepository;
import com.example.examprep3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {

            Arrays.stream(CategoryName.values())
                    .forEach(value -> {
                        Category category = new Category();
                        category.setName(value);

                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryName name) {
        return this.categoryRepository.findByName(name).orElse(null);
    }
}
