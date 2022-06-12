package ru.xamrah.budget.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xamrah.budget.domain.Account;
import ru.xamrah.budget.domain.Transaction;
import ru.xamrah.budget.domain.User;
import ru.xamrah.budget.repo.AccountRepo;
import ru.xamrah.budget.repo.TransactionRepo;
import ru.xamrah.budget.repo.UserRepo;

import java.time.LocalDateTime;

@Component
public class DataIni {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    public void init(){
        User user = new User("Иваной", "Иван", "Иванович", 21);
        userRepo.save(user);
        Account account = new Account(9999999L, user, "TestAccount","Test");
        accountRepo.save(account);
        Account account1 = new Account(888888L, user, "TestAcc", "Test");
        accountRepo.save(account1);
        Short status = 0;
        Transaction transaction = new Transaction(1L, account, 1000L, LocalDateTime.now(), status);
        transactionRepo.save(transaction);
    }
}
