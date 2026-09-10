package com.prorenta.financeservice.model.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record CurrencyRateDto(
        LocalDate date,
        BigDecimal rate
) {
}
