package com.example.angularshopwebsitebackend.model;


import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class User_roles {
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private int user_id;
//    @Column(name = "user_id", nullable = false, unique = true)
//    private int user_id;
    @Column(name = "role_id", nullable = false, unique = true)
    private int role_id;

    public User_roles() {

    }

    public User_roles(int user_id, int role_id) {
//        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
