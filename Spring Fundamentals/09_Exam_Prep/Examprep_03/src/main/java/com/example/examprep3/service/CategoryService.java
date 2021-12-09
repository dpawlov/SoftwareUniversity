package com.example.examprep3.service;


import com.example.examprep3.model.entity.Category;
import com.example.examprep3.model.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName name);
}
