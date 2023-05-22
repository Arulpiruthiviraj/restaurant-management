package com.arul.restaurantmanagement.service;

import com.arul.restaurantmanagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);

    boolean deleteUser(Long id);

    User findByEmail(String email);

    boolean deleteUserByEmail(String email);

    User updateUserByEmail(String email, User user);
}
