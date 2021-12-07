package com.example.examprep1.service;

import com.example.examprep1.model.entity.User;
import com.example.examprep1.model.service.UserServiceModel;
import com.example.examprep1.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderedByDesc();
}
