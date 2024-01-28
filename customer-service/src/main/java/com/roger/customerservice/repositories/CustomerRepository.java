package com.roger.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roger.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
