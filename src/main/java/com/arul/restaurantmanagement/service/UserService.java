package com.arul.restaurantmanagement.service;

import com.arul.restaurantmanagement.dto.user.UserDTO;
import com.arul.restaurantmanagement.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO updatedUserDTO);

    boolean deleteUser(Long id);

    UserDTO findByEmail(String email);

    boolean deleteUserByEmail(String email);

    UserDTO updateUserByEmail(String email, UserDTO userDTO);
}
