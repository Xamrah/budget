package ru.xamrah.budget.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
    private Long amount;
//    @Column(name = "category_id")
//    private Category category;
    private LocalDateTime processingTime;
    private Short status;

    public Transaction(Long number, Account account, Long amount, LocalDateTime processingTime, Short status) {
        this.number = number;
        this.account = account;
        this.amount = amount;
        this.processingTime = processingTime;
        this.status = status;
    }
}