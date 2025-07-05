package com.example.backend.service;

import com.example.backend.model.user.User;

public interface UserService {
    User findById(Long id);
    User findByEmail(String email);
    User findByUsername(String username);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
    Boolean exist(User user);
    Boolean existsById(Long id);
}
