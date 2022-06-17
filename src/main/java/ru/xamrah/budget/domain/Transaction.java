package ru.xamrah.budget.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type;
    private Long number;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
    private Long amount;
    @ManyToOne(targetEntity = Category.class)
    private Category category;
    private LocalDateTime processingTime;
    private Short status;

    public Transaction(Type type, Long number, Account account, Long amount, Category category, LocalDateTime processingTime, Short status) {
        this.type = type;
        this.number = number;
        this.account = account;
        this.amount = amount;
        this.category = category;
        this.processingTime = processingTime;
        this.status = status;
    }
}