package com.example.sd20204sof3062.buoi1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService inMemoryAuthentication() {
//        List<UserDetails> listAccounts = new ArrayList<>();
//        UserDetails userDetails1 = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("123"))
//                .build();
//        listAccounts.add(userDetails1);
//
//        UserDetails userDetails2 = User
//                .withUsername("user2")
//                .password(passwordEncoder().encode("1232"))
//                .build();
//        listAccounts.add(userDetails2);
//        return new InMemoryUserDetailsManager(listAccounts);
//    }
}
