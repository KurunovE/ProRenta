package com.example.backend.model.user;

import com.example.backend.model.deposit.Deposit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @Column(unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Deposit> deposits;
}
