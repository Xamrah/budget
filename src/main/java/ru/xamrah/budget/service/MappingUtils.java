package ru.xamrah.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xamrah.budget.domain.*;
import ru.xamrah.budget.repo.AccountRepo;
import ru.xamrah.budget.repo.CategoryRepo;
import ru.xamrah.budget.repo.TransactionRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Service
public class MappingUtils {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public TransactionDto mapToTransactionDto(Transaction transaction){
        TransactionDto dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setAccount(transaction.getAccount().getId());
        dto.setAmount(transaction.getAmount());
        dto.setNumber(transaction.getNumber());
        dto.setCategory(transaction.getCategory().getId());
        dto.setProcessingTime(transaction.getProcessingTime().toString());
        dto.setStatus(transaction.getStatus());

        return dto;
    }

    public Transaction mapToTransaction(TransactionDto dto){
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAccount(accountRepo.findById(dto.getAccount()).get());
        transaction.setAmount(dto.getAmount());
        transaction.setNumber(dto.getNumber());
        transaction.setCategory(categoryRepo.findById(dto.getCategory()).get());
        transaction.setProcessingTime(LocalDateTime.parse(dto.getProcessingTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        transaction.setStatus(dto.getStatus());
        transaction.setType(dto.getType());

        return transaction;
    }
}
