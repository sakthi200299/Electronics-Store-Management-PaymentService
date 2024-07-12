package com.ElectronicManagementSystemPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ElectronicsStoreManagementsystem.entity", "com.ElectronicManagementSystemPayment.entity"})
public class ElectronicManagementSystemPayment {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicManagementSystemPayment.class, args);
    }
}
