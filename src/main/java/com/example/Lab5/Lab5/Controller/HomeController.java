package com.example.Lab5.Lab5.Controller;
import com.example.Lab5.Lab5.Repository.UserRepository;
import com.example.Lab5.Lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Lab5.Lab5.Model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // Khởi tạo danh sách User
    public HomeController() {
    }

    // Trả về danh sách User
    @GetMapping("/users")
    @ResponseBody
    public List<Users> getUserList() {
        return userService.findAll();
    }

    // Trả về một User cụ thể theo ID
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int userId) {
        for (Users user : userService.findAll()) {
            if (user.getId() == userId) {
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body(null);  // Trả về lỗi 404 nếu không tìm thấy
    }

    // Xóa một User theo ID
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public List<Users> removeUserById(@PathVariable("id") Long userId) {
        userService.delete(userId);
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        userService.save(user);
        return ResponseEntity.status(201).body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> udpateUser(@PathVariable("id") Long userId, @RequestBody Users updateUser) {
        Users user = userService.findById(userId);
        if (user != null) {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            userService.save(user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);
    }
}
