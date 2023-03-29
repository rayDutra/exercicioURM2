package com.iftm.firststructure.controllers;

import com.iftm.firststructure.models.User;
import com.iftm.firststructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // Injecao de dependencias
    @Autowired
    private UserService userService;

    //CRUD
    // READ - HTTP GET
    // http://localhost:8080/api/users

    // http://localhost:8080/api/person/ID
    @GetMapping("/{id}")
    public Optional<User> find(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    // DELETE - HTTP DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
