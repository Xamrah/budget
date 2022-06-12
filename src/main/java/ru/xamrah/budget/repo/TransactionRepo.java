package ru.xamrah.budget.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ru.xamrah.budget.domain.Transaction;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
}
