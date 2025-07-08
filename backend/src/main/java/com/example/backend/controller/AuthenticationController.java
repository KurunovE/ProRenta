package com.example.backend.controller;

import com.example.backend.model.user.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody User user) {
        try {
            User registeredUser = userService.registration(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(registeredUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "status", 400,
                            "error", "Bad request",
                            "message", "Incorrect data: " + e.getMessage()
                    ));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of(
                            "status", 409,
                            "error", "Duplicate entry",
                            "message","A user with such an email already exists"
                    ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "status", 500,
                            "error","Internal Server Error",
                            "message","Internal server error"
                    ));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        //TODO
        return null;
    }
}
