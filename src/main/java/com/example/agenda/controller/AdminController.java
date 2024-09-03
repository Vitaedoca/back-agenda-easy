package com.example.agenda.controller;

import com.example.agenda.admin.Admin;
import com.example.agenda.admin.AdminRepository;
import com.example.agenda.admin.AdminRequestDTO;
import com.example.agenda.admin.AdminResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository repository;

    @GetMapping
    public ResponseEntity getAdmin() {
        List<AdminResponseDTO> list = repository.findAll().stream().map(AdminResponseDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity createAdmin(@RequestBody AdminRequestDTO data) {
        Admin admin = new Admin(data);
        repository.save(admin);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    @Transactional
    public ResponseEntity updateAdmin(@RequestBody AdminRequestDTO data) {
        Optional<Admin> optionalAdmin = repository.findById(data.adminId());

        if(optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setFullName(data.fullName());
            admin.setEmail(data.email());
            admin.setPasswordHash(data.passwordHash());
            return ResponseEntity.ok(admin);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
