package com.example.backend.controller;

import com.example.backend.model.user.User;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public User findUser(@RequestParam(value = "id", required = false) Long id,
                         @RequestParam(value = "email", required = false) String email,
                         @RequestParam(value = "username", required = false) String username) {
        if (id != null) {
            return userService.findById(id);
        } else if (email != null) {
            return userService.findByEmail(email);
        } else if (username != null) {
            return userService.findByUsername(username);
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(Long.parseLong(id));
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") Long id) {
        userService.deleteById(id);
    }
}
