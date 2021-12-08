package com.example.examprep2.service;

import com.example.examprep2.model.entity.enums.CategoryNameEnum;
import com.example.examprep2.model.service.ProductServiceModel;
import com.example.examprep2.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum);

    void buyById(Long id);

    void buyAll();

}
