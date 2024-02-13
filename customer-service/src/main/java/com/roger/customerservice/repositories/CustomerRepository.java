package com.roger.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roger.customerservice.entities.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    List<Customer> findByFirstNameContainsIgnoreCase(String keyword);
}
