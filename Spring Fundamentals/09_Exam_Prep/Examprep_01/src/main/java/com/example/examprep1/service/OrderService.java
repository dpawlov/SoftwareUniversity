package com.example.examprep1.service;

import com.example.examprep1.model.service.OrderServiceModel;
import com.example.examprep1.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderedByPricesDesc();

    void readyOrder(Long id);
}
