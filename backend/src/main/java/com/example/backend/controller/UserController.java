package com.example.backend.controller;

import com.example.backend.model.user.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> findUser(@RequestParam(value = "id", required = false) Long id,
                                      @RequestParam(value = "email", required = false) String email,
                                      @RequestParam(value = "username", required = false) String username) {
        User user;
        if (id != null) {
            user = userService.findById(id);
        } else if (email != null) {
            user = userService.findByEmail(email);
        } else if (username != null) {
            user = userService.findByUsername(username);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Incorrect parameters"
                    ));
        }
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                                "status", 404,
                                "error", "Not found",
                                "message", "User not found"
                        ));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Incorrect format id"
                    ));
        }
        var user = userService.findById(id);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                                "status", 404,
                                "error", "Not found",
                                "message", "User not found"
                        ));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        if (email == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Incorrect format email"
                    ));
        }
        var user = userService.findByEmail(email);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                                "status", 404,
                                "error", "Not found",
                                "message", "User not found"
                        ));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        if (username == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Incorrect format username"
                    ));
        }
        var user = userService.findByUsername(username);
        return (user != null) ?
                ResponseEntity.ok(user) :
                ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                                "status", 404,
                                "error", "Not found",
                                "message", "User not found"
                        ));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad request",
                            "message", "Incorrect user"
                    ));
        }
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam("id") Long id) {
        if (id == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad request",
                            "message", "Incorrect format id"
                    ));
        }
        if (userService.existsById(id)) {
            userService.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of(
                            "status", 200,
                            "message", "User deleted"));
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "status", 404,
                        "error", "Not found",
                        "message", "User not found"
                ));
    }
}
