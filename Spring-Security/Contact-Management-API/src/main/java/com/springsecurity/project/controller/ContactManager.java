package com.springsecurity.project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactManager {

    @GetMapping
    public String getContacts() {
        return "Returning all contacts";
    }

    @PostMapping
    public String addContact() {
        return "new contact added";
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable String id) {
        return "Contact " + id + "  deleted";
    }

    @GetMapping("/public/info")
    public String publicInfo() {
        return "This is a public endpoint";
    }
}
