package com.bank.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String sayHello(){
        return "Welcome to Hello Banking API!";
    }

    @PostMapping()
    public String greetUser(@RequestBody String name){
        return "Hello, " + name + "! Welcome to Hello Banking API!";
    }
}
