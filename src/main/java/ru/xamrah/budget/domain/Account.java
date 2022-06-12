package ru.xamrah.budget.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    @ManyToOne(targetEntity = User.class)
    private User owner;
    private String name;
    private String description;

    public Account(Long number, User owner, String name, String description) {
        this.number = number;
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

}
