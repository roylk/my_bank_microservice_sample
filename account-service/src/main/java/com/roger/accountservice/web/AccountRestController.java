package com.roger.accountservice.web;

import com.roger.accountservice.clients.CustomerRestClient;
import com.roger.accountservice.entities.BankAccount;
import com.roger.accountservice.models.Customer;
import com.roger.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(AccountRepository accountRepository, CustomerRestClient customerRestClient){
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccount(){
        List<BankAccount> accountList =accountRepository.findAll();
        accountList.forEach(acc-> {
            acc.setCustomer(customerRestClient.getCustomerById(acc.getCustomerId()));
        });
        //return accountRepository.findAll();
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getOneBankAccountById(@PathVariable  String id){

         BankAccount bankAccount = accountRepository.findById(id).get();
         Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
