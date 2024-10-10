package com.example.agenda.controller;


import com.example.agenda.client.Client;
import com.example.agenda.client.ClientRepository;
import com.example.agenda.client.ClientUpdateDTO;
import com.example.agenda.client.ClientsRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody ClientsRequestDTO data) {
        Client client = new Client(data);
        repository.save(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Client> updateUser(@PathVariable Long id, @RequestBody ClientUpdateDTO data) {
        Optional<Client> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            Client user = optionalUser.get();
            user.setName(data.name());
            user.setPhone(data.phone());
            user.setEmail(data.email());
            user.setPassword(data.password());
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
