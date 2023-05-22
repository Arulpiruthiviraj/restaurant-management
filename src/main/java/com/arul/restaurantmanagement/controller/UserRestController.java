package com.arul.restaurantmanagement.controller;

import com.arul.restaurantmanagement.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping(path = "/user")
public interface UserRestController {
    @GetMapping("")
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id);

    @PostMapping("")
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id);

    @GetMapping("/email/{email}")
    ResponseEntity<User> getUserByEmail(@PathVariable String email);

    @PutMapping("/email/{email}")
    ResponseEntity<User> updateUserByEmail(@PathVariable @NotBlank @Email String email, @Valid User user);

    @DeleteMapping("/email/{email}")
    ResponseEntity<Void> deleteUserByEmail(@PathVariable @NotBlank @Email String email);
}
