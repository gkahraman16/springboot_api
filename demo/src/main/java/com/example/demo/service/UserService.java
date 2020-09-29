package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteUser(Long id){
        repository.deleteById(id);
        return "User "+id+" is removed.";
    }

    public User updateUser(User user){
       User existingUser = repository.findById(user.getId()).orElse(null);
       existingUser.setName(user.getName());
       existingUser.setLastname(user.getLastname());
       existingUser.setAddress(user.getAddress());
       return repository.save(existingUser);
    }

}
