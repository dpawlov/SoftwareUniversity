package com.example.softuniexam.service;

import com.example.softuniexam.model.entity.enums.CategoryNameEnum;
import com.example.softuniexam.model.service.ProductServiceModel;
import com.example.softuniexam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum);

    void buyById(Long id);

    void buyAll();

}
