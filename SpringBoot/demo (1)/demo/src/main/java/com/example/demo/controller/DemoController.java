// Persistance Layer - DB related (Repository)
// Service Layer - Business Logics in between 1&3 (Service)
// Presentation Layer - Outside Communication (Controller)

package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController
{
    @GetMapping("/get")
    String show1()
    {
        return "Get";
    }

    @PostMapping("/post")
    String show3()
    {
        return "Post";
    }

    @PutMapping("/put")
    String show2()
    {
        return "Put";
    }

    @DeleteMapping("/delete")
    String show4()
    {
        return "Delete";
    }
}
