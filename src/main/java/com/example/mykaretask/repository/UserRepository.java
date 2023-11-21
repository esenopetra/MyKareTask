package com.example.mykaretask.repository;

import com.example.mykaretask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);

}