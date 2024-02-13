package com.roger.customerservice.mappers;

import com.roger.customerservice.dtos.CustomerDTO;
import com.roger.customerservice.entities.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    CustomerMapper underTest = new CustomerMapper();

    @Test
    public void  shouldMapCustomerToCustomerDTO(){
        Customer givenCustomer = Customer.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build();

        CustomerDTO expected = CustomerDTO.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build();

        CustomerDTO result = underTest.fromCustomer(givenCustomer);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(expected).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void  shouldMapCustomerDTOToCustomer(){
        CustomerDTO givenCustomerDTO = CustomerDTO.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build();

        Customer expected = Customer.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build();

        Customer result = underTest.fromCustomerDTO(givenCustomerDTO);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(expected).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void shouldMapCustomerListToCustomerDTOList(){
        List<Customer> givenCustomers = List.of(Customer.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build(),
                Customer.builder().id(2L).firstName("KOUANI").lastName("Roger").email("rk@email.com").build());

        List<CustomerDTO> expected =List.of(CustomerDTO.builder().id(1L).firstName("KOUANI").lastName("lyham").email("lk@email.com").build(),
                CustomerDTO.builder().id(2L).firstName("KOUANI").lastName("Roger").email("rk@email.com").build());
        List<CustomerDTO> result = underTest.fromCustomerList(givenCustomers);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(expected).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    public void  shouldNotMapNullToCustomerDTO(){
        Customer givenCustomer = null;
        AssertionsForClassTypes.assertThatThrownBy(() -> underTest.fromCustomer(givenCustomer)).isInstanceOf(IllegalArgumentException.class) ;
    }



}