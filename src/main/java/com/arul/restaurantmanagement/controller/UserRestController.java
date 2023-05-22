package com.arul.restaurantmanagement.controller;

import com.arul.restaurantmanagement.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/user")
public interface UserRestController {
    @GetMapping("/")
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id);

    @PostMapping("/")
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id);
}
