package ru.xamrah.budget.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xamrah.budget.domain.*;
import ru.xamrah.budget.repo.AccountRepo;
import ru.xamrah.budget.repo.CategoryRepo;
import ru.xamrah.budget.repo.TransactionRepo;
import ru.xamrah.budget.repo.UserRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataIni {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public void init(){
        User user = new User("Иваной", "Иван", "Иванович", 21);
        userRepo.save(user);
        Account account = new Account(9999999L, user, "TestAccount","Test");
        accountRepo.save(account);
        Account account1 = new Account(888888L, user, "TestAcc", "Test");
        accountRepo.save(account1);
        Category category = new Category("Другое");
        categoryRepo.save(category);
        Short status = 0;
        Transaction transaction = new Transaction(Type.EXPENSE, 1L, account, 1000L, category, LocalDateTime.now(), status);
        transactionRepo.save(transaction);
    }
}
