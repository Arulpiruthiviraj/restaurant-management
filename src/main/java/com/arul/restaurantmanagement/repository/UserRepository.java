package com.arul.restaurantmanagement.repository;

import com.arul.restaurantmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}