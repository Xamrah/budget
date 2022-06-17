package ru.xamrah.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xamrah.budget.domain.Transaction;
import ru.xamrah.budget.dto.TransactionDto;
import ru.xamrah.budget.factories.TransactionDtoFactory;
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
    TransactionDtoFactory transactionDtoFactory;


    @Override
    public void create(TransactionDto transactionDto) {
        transactionRepo.save(transactionDtoFactory.mapToTransaction(transactionDto));
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
        return transactionRepo.findTotalAmountWithProcessingTimeAfterById(id, LocalDateTime.now().minusMonths(1));

    }

    @Override
    public Long amountForThePeriod(Long id, LocalDateTime start, LocalDateTime end) {
        return transactionRepo.findTotalAmountWithProcessingTimeBetweenById(id, start, end);
    }

    @Override
    public Long totalAmount(Long id) {
        return transactionRepo.findTotalAmountById(id);
    }
}
