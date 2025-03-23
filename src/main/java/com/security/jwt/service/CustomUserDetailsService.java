package com.security.jwt.service;

import com.security.jwt.CustomUserDetails;
import com.security.jwt.entity.User;
import com.security.jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = userRepository.findByUserName(username);
        if(Objects.isNull(byUserName)){
            System.out.println("user not found..");
            throw new UsernameNotFoundException("user not available");
        }
        return new CustomUserDetails(byUserName);
    }
}
