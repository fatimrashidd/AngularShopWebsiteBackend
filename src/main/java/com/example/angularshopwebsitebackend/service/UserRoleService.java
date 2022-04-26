package com.example.angularshopwebsitebackend.service;

import com.example.angularshopwebsitebackend.model.Roles;
import com.example.angularshopwebsitebackend.model.User;
import com.example.angularshopwebsitebackend.model.User_roles;
import com.example.angularshopwebsitebackend.repository.RoleRepo;
import com.example.angularshopwebsitebackend.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepo userRoleRepository;

    public String saveUserRole(User_roles user_roles){
        userRoleRepository.save(user_roles); //build in method
        return "user successfully registered :)!!";
    }


}

