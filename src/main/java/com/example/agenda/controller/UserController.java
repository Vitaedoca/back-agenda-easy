package com.example.agenda.controller;


import com.example.agenda.user.UserRepository;
import com.example.agenda.user.UserUpdateDTO;
import com.example.agenda.user.Users;
import com.example.agenda.user.UsersRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersRequestDTO data) {
        Users user = new Users(data);
        repository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO data) {
        Optional<Users> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setFullName(data.fullName());
            user.setPhoneNumber(data.phoneNumber());
            user.setEmail(data.email());
            user.setPasswordHash(data.passwordHash());
            repository.save(user);  // Salva as mudanças no banco de dados
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsers(@PathVariable Long id) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
    }

}
