package ru.xamrah.budget.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private Integer age;
    @OneToMany(targetEntity = Account.class, mappedBy = "owner")
    private List<Account> accounts;

    public User(String surname, String firstName, String secondName, Integer age) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
}
