package com.example.Lab5.Lab5.Repository;
import com.example.Lab5.Lab5.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
