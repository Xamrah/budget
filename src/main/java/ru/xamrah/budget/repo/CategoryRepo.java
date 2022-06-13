package ru.xamrah.budget.repo;

import org.springframework.data.repository.CrudRepository;
import ru.xamrah.budget.domain.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
