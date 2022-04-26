package com.example.angularshopwebsitebackend.controller;

import com.example.angularshopwebsitebackend.model.User_roles;
import com.example.angularshopwebsitebackend.repository.UserRepo;
import com.example.angularshopwebsitebackend.service.UserRoleService;
import com.example.angularshopwebsitebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.*;
import com.example.angularshopwebsitebackend.model.User;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

@RestController //response only
public class UserController {

    //when ever the user will submit the form it will store in the database

    @Autowired //create an object
    private UserService userService;

    @Autowired
    UserRepo userRepository;

    @Autowired
    UserRoleService userRoleService;

    //register a user and check email
//    @PostMapping(path = "/registration")
//    @RequestMapping(value = "/registration", method = POST)
//    @Procedure("application/json")
    @PostMapping(value = "/registration")
    public User registerUser(@RequestBody User user) throws Exception {

        String tempEmail = user.getEmail();

        //in order to check if the email is our database or not
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userObject = userService.fetchUserByEmail(tempEmail);

            if (userObject != null) {
                throw new Exception("User with " + tempEmail + " is already exists in our database !!");
            }

        }

        userService.saveUser(user);
        return user;

    }

    @GetMapping(path = "/UsersInfo")
    @Procedure("application/json")
    public List<User> getAllUser() {

        List<User> allUsers = userRepository.findAll();
        return allUsers;

    }

    //get by a specific id
    @GetMapping(path = "/UserRegistration/{id}")
    public Optional<User> getSpecificUser(@PathVariable int id) {
        return userRepository.findById((long) id);
    }

    //create a user
    public User createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    //update
    @PutMapping(path = "/UserRegistration/{id}")
    public String UpdateUser(@RequestBody User user) {

        Long id = user.getId();
        userRepository.save(user);

        return "User with " + id + " is successfully updated";
    }

    //delete
    @DeleteMapping(path = "/UserRegistration/{id}")
    public String deleteUser(@PathVariable int id) {

        User userDelete = userRepository.getOne((long) id);
        userRepository.delete(userDelete);

        return "User with " + id + " is successfully delete";
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody User user) {

        User databaseUser = userService.fetchUserByEmail(user.getEmail());

        if (user.getEmail().equals(databaseUser.getEmail()) && user.getPassword().equals(databaseUser.getPassword())){
            return databaseUser;
        }
        else
            return null;
        }

    @PostMapping(value = "/roles")
    public String assignRole(@RequestBody User_roles user_roles){
        userRoleService.saveUserRole(user_roles);
        return "assiged successfully";
    }
}

