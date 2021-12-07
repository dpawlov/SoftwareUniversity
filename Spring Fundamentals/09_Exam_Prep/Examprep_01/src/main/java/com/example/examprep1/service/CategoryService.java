package com.example.examprep1.service;

import com.example.examprep1.model.entity.Category;
import com.example.examprep1.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
