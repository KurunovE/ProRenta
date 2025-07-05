package com.example.backend.service.impl;

import com.example.backend.model.deposit.Deposit;
import com.example.backend.repository.DepositRepository;
import com.example.backend.service.DepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepositServiceImpl implements DepositService {
    private final DepositRepository depositRepository;

    @Override
    public Deposit findById(Long id) {
        return depositRepository.findById(id).orElse(null);
    }

    @Override
    public Deposit save(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public void delete(Deposit deposit) {
        depositRepository.delete(deposit);
    }
}
