package ru.xamrah.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xamrah.budget.domain.Transaction;
import ru.xamrah.budget.domain.TransactionDto;
import ru.xamrah.budget.repo.CategoryRepo;
import ru.xamrah.budget.repo.TransactionRepo;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    MappingUtils mappingUtils;

    @Override
    public void create(TransactionDto transaction) {
        transactionRepo.save(mappingUtils.mapToTransaction(transaction));
    }

    @Override
    public boolean changeCategory(Long categoryId, Long id) {
        Transaction transaction = transactionRepo.findById(id).orElseGet(null);
        if(transaction != null){
            transaction.setCategory(categoryRepo.findById(categoryId).get());
            transactionRepo.save(transaction);
            return true;
        }
        return false;
    }

    @Override
    public Long amountForTheLastMonth(Long id) {
        return null;
    }

    @Override
    public Long amountForThePeriod(LocalDateTime start, LocalDateTime end, Long id) {
        return null;
    }

    @Override
    public Long totalAmount(Long id) {
        return null;
    }
}
