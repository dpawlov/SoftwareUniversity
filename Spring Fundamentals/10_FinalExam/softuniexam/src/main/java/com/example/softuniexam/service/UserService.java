package com.example.softuniexam.service;

import com.example.softuniexam.model.service.UserServiceModel;

public interface UserService {

    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
