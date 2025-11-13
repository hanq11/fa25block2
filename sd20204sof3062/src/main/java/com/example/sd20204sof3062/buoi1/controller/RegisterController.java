package com.example.sd20204sof3062.buoi1.controller;

import com.example.sd20204sof3062.buoi1.entity.Account;
import com.example.sd20204sof3062.buoi1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/show-form")
    public String showForm() {
        return "/register";
    }

    @PostMapping("/submit")
    public String register(Account account) {
        account.setPassword(
                passwordEncoder.encode(account.getPassword())
        );
        accountRepository.save(account);
        return "redirect:/login";
    }
}
