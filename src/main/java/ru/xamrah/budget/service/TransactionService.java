package ru.xamrah.budget.service;

import ru.xamrah.budget.domain.Transaction;
import ru.xamrah.budget.domain.TransactionDto;

import java.time.LocalDateTime;

public interface TransactionService {
    void create(TransactionDto transaction);
    boolean changeCategory(Long categoryId, Long id);
    Long amountForTheLastMonth(Long id);
    Long amountForThePeriod(LocalDateTime start, LocalDateTime end, Long id);
    Long totalAmount(Long id);
}
