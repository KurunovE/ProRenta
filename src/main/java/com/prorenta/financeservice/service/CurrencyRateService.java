package com.prorenta.financeservice.service;

import com.prorenta.financeservice.model.dto.ListCurrencyRatesResponseDto;

import java.time.LocalDate;

public interface CurrencyRateService {
    void aggregateRates();
    ListCurrencyRatesResponseDto getCurrencyRates(
            String currencyCode,
            LocalDate startDate,
            LocalDate endDate
    );
}
