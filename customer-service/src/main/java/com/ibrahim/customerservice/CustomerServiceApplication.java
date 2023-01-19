package com.ibrahim.customerservice;

import com.ibrahim.customerservice.entities.Customer;
import com.ibrahim.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration)
    {
        return args ->{
            restConfiguration.exposeIdsFor(Customer.class);
        customerRepository.findAll().forEach(c->{
            System.out.println(c);
        });
        };
    }
}
