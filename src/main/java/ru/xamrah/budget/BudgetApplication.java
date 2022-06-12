package ru.xamrah.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.xamrah.budget.util.DataIni;

@SpringBootApplication
public class BudgetApplication implements CommandLineRunner {

    @Autowired
    private DataIni dataIni;

    public static void main(String[] args) {
        SpringApplication.run(BudgetApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        dataIni.init();
    }
}
