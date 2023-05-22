package com.arul.restaurantmanagement.service.impl;

import com.arul.restaurantmanagement.dto.user.UserDTO;
import com.arul.restaurantmanagement.entity.User;
import com.arul.restaurantmanagement.repository.UserRepository;
import com.arul.restaurantmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserDTO::new).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userDTO.toUser();
        User createdUser = userRepository.save(user);
        return new UserDTO(createdUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO updatedUserDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            User updatedUser = updatedUserDTO.toUser();
            updateUserFields(user, updatedUser);
            User savedUser = userRepository.save(user);
            return new UserDTO(savedUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null ? new UserDTO(user) : null;
    }

    @Override
    public UserDTO updateUserByEmail(String email, UserDTO userDTO) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            User user = userDTO.toUser();
            user.setId(existingUser.getId());
            User updatedUser = userRepository.save(user);
            return new UserDTO(updatedUser);
        }
        return null;
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }

    private void updateUserFields(User user, User updatedUser) {
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setContactNumber(updatedUser.getContactNumber());
        user.setStatus(updatedUser.getStatus());
        user.setRole(updatedUser.getRole());
    }
}
