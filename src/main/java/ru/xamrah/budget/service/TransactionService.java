package ru.xamrah.budget.service;

import ru.xamrah.budget.dto.TransactionDto;

import java.time.LocalDateTime;

public interface TransactionService {
    void create(TransactionDto transaction);
    boolean changeCategory(Long id, Long categoryId);
    Long amountForTheLastMonth(Long id);
    Long amountForThePeriod(Long id, LocalDateTime start, LocalDateTime end);
    Long totalAmount(Long id);
}
