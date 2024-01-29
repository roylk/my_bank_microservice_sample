package com.roger.accountservice.repositories;

import com.roger.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
