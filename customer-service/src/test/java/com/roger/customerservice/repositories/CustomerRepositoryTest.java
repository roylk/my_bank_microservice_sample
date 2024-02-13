package com.roger.customerservice.repositories;

import com.roger.customerservice.entities.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    public void setUp(){
        customerRepository.save(Customer.builder()
                .firstName("kouani").lastName("roger").email("crk@email.com")
                .build());
        customerRepository.save(Customer.builder()
                .firstName("kouani").lastName("lyham").email("lyk@email.com")
                .build());
        customerRepository.save(Customer.builder()
                .firstName("toukam").lastName("victorine").email("vt@email.com")
                .build());
    }
    @Test
    public void shouldFindCustomerByEmail(){
        String givenEmail = "lyk@email.com";
        Optional<Customer> result = customerRepository.findByEmail(givenEmail);
        assertThat(result).isPresent();
    }

    @Test
    public void shouldNotFindCustomerByEmail(){
        String givenEmail = "lxxxk@emlxx.com";
        Optional<Customer> result = customerRepository.findByEmail(givenEmail);
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindCustomerByFirstName(){
        String keyword = "ni";
        List<Customer> expected = List.of(Customer.builder()
                .firstName("kouani").lastName("roger").email("crk@email.com")
                .build(),
                Customer.builder()
                        .firstName("kouani").lastName("lyham").email("lyk@email.com")
                        .build()
                );
        List<Customer> result = customerRepository.findByFirstNameContainsIgnoreCase(keyword);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(expected.size());
        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(expected);
    }

}