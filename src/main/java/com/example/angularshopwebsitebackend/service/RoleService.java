package com.example.angularshopwebsitebackend.service;

import com.example.angularshopwebsitebackend.model.Roles;
import com.example.angularshopwebsitebackend.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;

public class RoleService {

    @Autowired
    RoleRepo roleRepository;

    public Roles findRoleByid(int id){
        return roleRepository.findByid(id);
    }


}
