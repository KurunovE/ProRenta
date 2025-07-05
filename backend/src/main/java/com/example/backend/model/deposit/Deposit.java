package com.example.backend.model.deposit;

import com.example.backend.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double balance;

    @Column
    private Double interestRate;

    @Column
    private int termInMonth;

    @Column
    private String currency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
