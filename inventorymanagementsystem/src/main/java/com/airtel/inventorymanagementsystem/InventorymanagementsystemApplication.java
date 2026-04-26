package com.airtel.inventorymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.airtel.inventory"})
@EntityScan(basePackages = {"com.airtel.inventory.model"})
@EnableJpaRepositories(basePackages = {"com.airtel.inventory.repository"})
@EnableJpaAuditing
public class InventorymanagementsystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventorymanagementsystemApplication.class, args);
        System.out.println("========================================");
        System.out.println("Inventory Management System Started!");
        System.out.println("Access at: http://localhost:8080");
        System.out.println("========================================");
    }
}
