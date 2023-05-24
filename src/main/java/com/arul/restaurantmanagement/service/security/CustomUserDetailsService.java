package com.arul.restaurantmanagement.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService extends UserDetailsService {
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;

    UserDetails loadUserById(Long id) throws UsernameNotFoundException;
}
