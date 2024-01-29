package com.roger.accountservice.web;

import com.roger.accountservice.entities.BankAccount;
import com.roger.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccount(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getOneBankAccountById(@PathVariable  String id){
        return accountRepository.findById(id).get();
    }

}
