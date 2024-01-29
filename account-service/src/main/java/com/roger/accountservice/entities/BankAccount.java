package com.roger.accountservice.entities;

import com.roger.accountservice.enums.AccountType;
import com.roger.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
