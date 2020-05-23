package com.epam.demo;

import com.epam.demo.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    CreditCardService creditCardService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
