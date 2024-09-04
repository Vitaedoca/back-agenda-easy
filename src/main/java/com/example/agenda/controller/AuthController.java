package com.example.agenda.controller;


import com.example.agenda.admin.Admin;
import com.example.agenda.admin.AdminRepository;
import com.example.agenda.auth.LoginRequestDTO;
import com.example.agenda.auth.RegisterRequestDTO;
import com.example.agenda.auth.ResponseDTO;
import com.example.agenda.infra.security.TokenService;
import com.example.agenda.user.UserRepository;
import com.example.agenda.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Users user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPasswordHash())) {
            String token = this.tokenService.generatetoken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getFullName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<Users> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            Users newUser = new Users();
            newUser.setPasswordHash(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setFullName(body.name());
            this.repository.save(newUser);

            String token = this.tokenService.generatetoken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getFullName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
