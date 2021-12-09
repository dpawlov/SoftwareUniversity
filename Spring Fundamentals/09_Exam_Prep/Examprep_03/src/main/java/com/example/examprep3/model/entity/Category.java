package com.example.examprep3.model.entity;


import com.example.examprep3.model.enums.CategoryName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryName name;

    public Category() {
    }

    @Enumerated(value = EnumType.STRING)
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }
}
