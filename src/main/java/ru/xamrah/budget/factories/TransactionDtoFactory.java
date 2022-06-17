package ru.xamrah.budget.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.xamrah.budget.domain.*;
import ru.xamrah.budget.dto.TransactionDto;
import ru.xamrah.budget.repo.AccountRepo;
import ru.xamrah.budget.repo.CategoryRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionDtoFactory {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public TransactionDto mapToTransactionDto(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .account(transaction.getAccount().getId())
                .amount(transaction.getAmount())
                .number(transaction.getNumber())
                .category(transaction.getCategory().getId())
                .processingTime(transaction.getProcessingTime().toString())
                .status(transaction.getStatus())
                .build();
    }

    public Transaction mapToTransaction(TransactionDto dto){
        return Transaction.builder()
                .id(dto.getId())
                .account(accountRepo.findById(dto.getAccount()).get())
                .amount(dto.getAmount())
                .number(dto.getNumber())
                .category(categoryRepo.findById(dto.getCategory()).get())
                .processingTime(LocalDateTime.parse(dto.getProcessingTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .status(dto.getStatus())
                .type(dto.getType())
                .build();
    }
}
