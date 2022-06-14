package ru.xamrah.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.xamrah.budget.domain.TransactionDto;
import ru.xamrah.budget.service.TransactionService;

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
    public ResponseEntity<?> changeCategory(@PathVariable(name = "id") Long id, @RequestBody Long categoryId){
        transactionService.changeCategory(categoryId,id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
