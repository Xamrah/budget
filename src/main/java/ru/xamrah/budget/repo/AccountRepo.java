package ru.xamrah.budget.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xamrah.budget.domain.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
}
