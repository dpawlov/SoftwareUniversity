package com.example.examprep3.service.impl;

import com.example.examprep3.model.entity.Product;
import com.example.examprep3.model.service.ProductServiceModel;
import com.example.examprep3.repository.ProductRepository;
import com.example.examprep3.service.CategoryService;
import com.example.examprep3.service.ProductService;
import com.example.examprep3.service.SexService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SexService sexService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, SexService sexService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.sexService = sexService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean add(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setCategory(this.categoryService.findByName(productServiceModel.getCategory()));
        product.setSex(this.sexService.findBySex(productServiceModel.getSex()));
        try {
            productRepository.save(product);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<ProductServiceModel> getAllProducts() {
        return this.productRepository.findAll().stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ProductServiceModel getByName(String name) {
        return this.productRepository.findByName(name)
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .orElse(null);
    }

    @Override
    public void deleteByName(String name) {
        this.productRepository.findByName(name)
                .ifPresent(this.productRepository::delete);

    }
}
