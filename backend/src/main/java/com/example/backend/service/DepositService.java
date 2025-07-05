package com.example.backend.service;

import com.example.backend.model.deposit.Deposit;

public interface DepositService {
    Deposit findById(Long id);
    Deposit save(Deposit deposit);
    void delete(Deposit deposit);
}
