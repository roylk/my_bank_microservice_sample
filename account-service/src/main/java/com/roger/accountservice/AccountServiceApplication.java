package com.roger.accountservice;

import com.roger.accountservice.enums.AccountType;
import com.roger.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.roger.accountservice.entities.BankAccount;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            BankAccount account1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(86000)
                    .currency("EURO")
                    .createdAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();

            BankAccount account2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(90000)
                    .currency("EURO")
                    .createdAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();

            accountRepository.save(account1);
            accountRepository.save(account2);
        };

    }

}
