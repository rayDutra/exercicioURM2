package com.iftm.firststructure.controllers;

import com.iftm.firststructure.models.Email;
import com.iftm.firststructure.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmailController {

    // Injecao de dependencias
    @Autowired
    private EmailService emailService;

    //CRUD
    // READ - HTTP GET
    // http://localhost:8080/api/users

    // http://localhost:8080/api/person/ID
    @GetMapping("email/{id}")
    public Optional<Email> find(@PathVariable("id") Long id) {
        return emailService.findById(id);
    }

    @PostMapping("email")
    public Email save(@RequestBody Email email) {
        return emailService.save(email);
    }

    @PutMapping("email")
    public Email update(@RequestBody Email email) {
        return emailService.update(email);
    }

    // DELETE - HTTP DELETE
    @DeleteMapping("email/{id}")
    public String delete(@PathVariable("id") Long id) {
        return emailService.delete(id);
    }
}
