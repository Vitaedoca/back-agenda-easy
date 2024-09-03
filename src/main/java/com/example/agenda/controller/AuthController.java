package com.example.agenda.controller;


import com.example.agenda.admin.Admin;
import com.example.agenda.admin.AdminRepository;
import com.example.agenda.auth.LoginRequestDTO;
import com.example.agenda.auth.RegisterRequestDTO;
import com.example.agenda.auth.ResponseDTO;
import com.example.agenda.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Admin admin = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), admin.getPasswordHash())) {
            String token = this.tokenService.generatetoken(admin);
            return ResponseEntity.ok(new ResponseDTO(admin.getFullName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<Admin> admin = this.repository.findByEmail(body.email());

        if(admin.isEmpty()) {
            Admin newAdmin = new Admin();
            newAdmin.setPasswordHash(passwordEncoder.encode(body.password()));
            newAdmin.setEmail(body.email());
            newAdmin.setFullName(body.name());
            this.repository.save(newAdmin);

            String token = this.tokenService.generatetoken(newAdmin);
            return ResponseEntity.ok(new ResponseDTO(newAdmin.getFullName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
