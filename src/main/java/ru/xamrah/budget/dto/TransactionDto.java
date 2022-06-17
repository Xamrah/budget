package ru.xamrah.budget.dto;

import lombok.Builder;
import lombok.Data;
import ru.xamrah.budget.domain.Type;

@Data
@Builder
public class TransactionDto {
    Long id;
    Type type;
    Long number;
    Long account;
    Long amount;
    Long category;
    String processingTime;
    Short status;
}
