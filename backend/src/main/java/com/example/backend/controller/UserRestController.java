package com.example.backend.controller;

import com.example.backend.model.user.User;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<User> findUser(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "username", required = false) String username) {
        if (id != null) {
            return ResponseEntity.ok(userService.findById(id));
        } else if (email != null) {
            return ResponseEntity.ok(userService.findByEmail(email));
        } else if (username != null) {
            return ResponseEntity.ok(userService.findByUsername(username));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        var user = userService.findByEmail(email);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        var user = userService.findByUsername(username);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        try {
            User savedUser = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body("Incorrect data" + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A user with such an email already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteById(@RequestParam("id") Long id) {
        if (userService.existsById(id)) {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
