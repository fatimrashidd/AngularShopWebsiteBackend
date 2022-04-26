package com.example.angularshopwebsitebackend.repository;

import com.example.angularshopwebsitebackend.model.Roles;
import com.example.angularshopwebsitebackend.model.User_roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<User_roles, Long>{

}
