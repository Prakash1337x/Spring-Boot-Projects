package com.example.demo;
// Persistence Layer - DB (Repository)
// Service Layer - logics for processing (Service)
// Presentation Layer - outside code (Controller)

// HTTPStatus
// 200 range - Success, 400 range - failure, 500 range - Server error

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication
{
    public static void main(String[] args)
    {
         SpringApplication.run(DemoApplication.class, args);
    }
}
