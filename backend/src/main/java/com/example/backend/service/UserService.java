package com.example.backend.service;

import com.example.backend.model.user.User;

public interface UserService {
    User findById(Long id);
    User findByEmail(String email);
    User findByUsername(String username);
    User registration(User user);
    User update(User user);
    void deleteById(Long id);
    Boolean existsById(Long id);
}
