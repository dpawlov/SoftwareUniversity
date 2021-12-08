package com.example.examprep2.service.impl;

import com.example.examprep2.model.entity.Product;
import com.example.examprep2.model.entity.enums.CategoryNameEnum;
import com.example.examprep2.model.service.ProductServiceModel;
import com.example.examprep2.model.view.ProductViewModel;
import com.example.examprep2.repository.ProductRepository;
import com.example.examprep2.service.CategoryService;
import com.example.examprep2.service.ProductService;
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
        return productRepository.findTotalProductsSum();

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
