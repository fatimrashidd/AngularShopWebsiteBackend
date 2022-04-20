package com.example.angularshopwebsitebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.angularshopwebsitebackend.model.User;
import com.example.angularshopwebsitebackend.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;


    public String saveUser(User user){
        userRepository.save(user); //build in method
        return "user successfully registered :)!!";
    }

    public User fetchUserByEmail(String email){
        return userRepository.findByEmail(email);
    }


}
