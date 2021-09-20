package com.example.springdatademo.services;

import com.example.springdatademo.models.User;
import com.example.springdatademo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User u = this.userRepository.getByUsername(user.getUsername());

        if(u != null){
            throw new UnsupportedOperationException("user already exist");
        }

        this.userRepository.save(user);
    }
}