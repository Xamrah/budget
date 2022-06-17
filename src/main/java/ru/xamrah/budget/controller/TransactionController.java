package ru.xamrah.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xamrah.budget.dto.TransactionDto;
import ru.xamrah.budget.service.TransactionService;

import java.time.LocalDateTime;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/transaction")
    public ResponseEntity<?> create(@RequestBody TransactionDto transaction){
        transactionService.create(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/transaction/{id}")
    public ResponseEntity<?> changeCategory(@PathVariable(name = "id") Long id, @RequestParam Long categoryId){
        transactionService.changeCategory(categoryId,id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "transaction/amount/{id}")
    public Long getTotalAmount(@PathVariable(name = "id") Long id){
        return transactionService.totalAmount(id);
    }

    @GetMapping(value = "transaction/amount/last/{id}")
    public Long getTotalAmountForTheLastMonth(@PathVariable(name = "id") Long id){
        return transactionService.amountForTheLastMonth(id);
    }

    @GetMapping(value = "transaction/amount/period/{id}")
    public Long getTotalAmountForThePeriod(@PathVariable(name = "id") Long id, @RequestParam String start, @RequestParam String end){
        return transactionService.amountForThePeriod(id, LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

}
