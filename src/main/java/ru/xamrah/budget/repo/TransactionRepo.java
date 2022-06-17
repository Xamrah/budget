package ru.xamrah.budget.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.xamrah.budget.domain.Transaction;

import java.time.LocalDateTime;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    @Query("select sum(t.amount) from Transaction t where t.processingTime >= :dateAgo and t.account.id = :id")
    Long findTotalAmountWithProcessingTimeAfterById(@Param("id") Long id, @Param("dateAgo") LocalDateTime dateAgo);

    @Query("select sum(t.amount) from Transaction t where t.processingTime >= :dateStart and t.processingTime <= :dateEnd and t.account.id = :id")
    Long findTotalAmountWithProcessingTimeBetweenById(@Param("id") Long id, @Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query("select sum(t.amount) from Transaction t where t.account.id = :id")
    Long findTotalAmountById(@Param("id") Long id);
}
