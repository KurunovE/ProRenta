package com.example.backend.service.impl;

import com.example.backend.model.user.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if (userOptional.isPresent()) {
            var newUser = userOptional.get();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setDeposits(user.getDeposits());
            return userRepository.save(newUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public Boolean exist(User user) {
        return userRepository.findByEmail(user.getEmail()) != null;
    }

    @Override
    public Boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

}
