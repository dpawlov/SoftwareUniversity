package com.example.examprep2.service.impl;

import com.example.examprep2.model.entity.User;
import com.example.examprep2.model.service.UserServiceModel;
import com.example.examprep2.repository.UserRepository;
import com.example.examprep2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        userRepository
                .save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
