package com.springboot.example.controller;

import com.springboot.example.dto.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController()
public class HelloController {

    // NORMAL TEXT FORMAT
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/hello/{name}")
    public String helloParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello, " + name + "!";
    }

    // JSON FORMAT
    @GetMapping("/hello")
    public HelloResponse helloJSON(){
        return new HelloResponse("Hello World!");
    }

    @PostMapping("/hello")
    public HelloResponse helloPostJSON(@RequestBody String name){
        return new HelloResponse("Hello, " + name + "!");
    }
}
