package com.example.Lab5.Lab5.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")   // Đảm bảo tên bảng trong DB khớp với tên này
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Sử dụng Integer thay vì int để hỗ trợ giá trị null

    private String name;
    private String email;

    // Constructor có tham số
    public Users(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Constructor mặc định
    public Users() {
    }

    // Getter và Setter cho các trường
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
