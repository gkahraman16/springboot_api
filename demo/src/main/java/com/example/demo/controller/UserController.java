package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RotaPlanApiv1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.println("User added");
        return userService.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        System.out.println("Users added");
        return userService.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
