package com.example.angularshopwebsitebackend.repository;

import com.example.angularshopwebsitebackend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Roles, Long> {
    public Roles findByid(int id);

}
