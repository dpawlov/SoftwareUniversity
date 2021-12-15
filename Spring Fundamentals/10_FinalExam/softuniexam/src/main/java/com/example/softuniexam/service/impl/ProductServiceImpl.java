package com.example.softuniexam.service.impl;

import com.example.softuniexam.model.entity.Product;
import com.example.softuniexam.model.entity.enums.CategoryNameEnum;
import com.example.softuniexam.model.service.ProductServiceModel;
import com.example.softuniexam.model.view.ProductViewModel;
import com.example.softuniexam.repository.ProductRepository;
import com.example.softuniexam.service.CategoryService;
import com.example.softuniexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(ProductServiceModel productServiceModel) {

        Product product = modelMapper.map(productServiceModel, Product.class);

        product.setCategory(categoryService
                .findByName(productServiceModel
                        .getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {

        return this.productRepository.findTotalProductsSum() == null
                ? BigDecimal.ZERO
                : this.productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum) {

        return productRepository
                .findAllByCategory_Name(categoryNameEnum)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
