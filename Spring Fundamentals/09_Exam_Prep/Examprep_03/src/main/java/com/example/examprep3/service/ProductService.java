package com.example.examprep3.service;


import com.example.examprep3.model.service.ProductServiceModel;

import java.util.List;

public interface ProductService {
    boolean add(ProductServiceModel productServiceModel);

    List<ProductServiceModel> getAllProducts();

    ProductServiceModel getByName(String name);

    void deleteByName(String name);
}
