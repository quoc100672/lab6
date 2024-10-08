package com.example.Lab5.Lab5.service;


import com.example.Lab5.Lab5.Model.Users;
import com.example.Lab5.Lab5.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<Users> findAll() {
        return userRepository.findAll();
    }


    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }


    public Users save(Users user) {
        return userRepository.save(user);
    }


    public Users update(Users user) {
        return userRepository.save(user);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}



