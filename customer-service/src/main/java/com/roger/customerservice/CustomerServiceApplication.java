package com.roger.customerservice;

import com.roger.customerservice.entities.Customer;
import com.roger.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("KOUANI")
							.lastName("Roger")
							.email("roger@email.com")
							.build(),
					Customer.builder()
							.firstName("KOUANI")
							.lastName("Lyham")
							.email("lyham@email.com")
							.build(),
					Customer.builder()
							.firstName("KAMDOUM")
							.lastName("Victorine")
							.email("vicky@email.com")
							.build()
			);
			//Customer customer = new Customer();

			customerRepository.saveAll(customerList);

		};
	}

}
