package com.arul.restaurantmanagement.controller;

import com.arul.restaurantmanagement.dto.user.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping(path = "/user")
public interface UserRestController {
    @GetMapping("")
    ResponseEntity<List<UserDTO>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id);

    @PostMapping("")
    ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO);

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long id);

    @GetMapping("/email/{email}")
    ResponseEntity<UserDTO> getUserByEmail(@PathVariable @NotBlank @Email String email);

    @PutMapping("/email/{email}")
    ResponseEntity<UserDTO> updateUserByEmail(@PathVariable @NotBlank @Email String email, @RequestBody @Valid UserDTO userDTO);

    @DeleteMapping("/email/{email}")
    ResponseEntity<Void> deleteUserByEmail(@PathVariable @NotBlank @Email String email);
}
