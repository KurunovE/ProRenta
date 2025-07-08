package com.example.backend.model.user;

import com.example.backend.model.deposit.Deposit;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Deposit> deposits;
}
