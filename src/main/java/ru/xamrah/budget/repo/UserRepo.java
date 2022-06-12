package ru.xamrah.budget.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.xamrah.budget.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
