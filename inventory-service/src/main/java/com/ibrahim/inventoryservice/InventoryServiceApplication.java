package com.ibrahim.inventoryservice;

import com.ibrahim.inventoryservice.entities.Product;
import com.ibrahim.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration)
    {
        return args ->{
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }
}
