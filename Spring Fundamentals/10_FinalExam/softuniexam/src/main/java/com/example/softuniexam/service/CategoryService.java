package com.example.softuniexam.service;

import com.example.softuniexam.model.entity.Category;
import com.example.softuniexam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByName(CategoryNameEnum categoryNameEnum);
}
