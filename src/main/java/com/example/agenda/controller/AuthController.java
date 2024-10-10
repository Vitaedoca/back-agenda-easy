package com.example.agenda.controller;


import com.example.agenda.auth.LoginRequestDTO;
import com.example.agenda.auth.RegisterRequestDTO;
import com.example.agenda.auth.ResponseDTO;
import com.example.agenda.client.Client;
import com.example.agenda.infra.security.TokenService;
import com.example.agenda.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Client client = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), client.getPassword())) {
            String token = this.tokenService.generatetoken(client);
            return ResponseEntity.ok(new ResponseDTO(client.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<Client> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            Client newUser = new Client();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            this.repository.save(newUser);

            String token = this.tokenService.generatetoken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
