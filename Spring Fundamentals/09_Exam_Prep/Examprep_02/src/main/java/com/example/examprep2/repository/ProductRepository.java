package com.example.examprep2.repository;

import com.example.examprep2.model.entity.Product;
import com.example.examprep2.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);
}
