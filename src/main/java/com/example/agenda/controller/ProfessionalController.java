package com.example.agenda.controller;


import com.example.agenda.appointments.Appointments;
import com.example.agenda.appointments.AppointmentsResponseDTO;
import com.example.agenda.professional.Professional;
import com.example.agenda.professional.ProfessionalRepository;
import com.example.agenda.professional.ProfessionalRequestDTO;
import com.example.agenda.professional.UpdateProfessionalDTO;
import jakarta.transaction.Transactional;
import jdk.javadoc.doclet.Reporter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalRepository repository;


    @GetMapping
    public ResponseEntity getProfessional() {
        var professional = repository.findAll();
        return ResponseEntity.ok(professional);
    }

    @GetMapping("porID/{id}")
    public ResponseEntity<ProfessionalRequestDTO> getProfessionalById(@PathVariable Long id) {
        Optional<Professional> professional = repository.findById(id);
        if (professional.isPresent()) {
            return ResponseEntity.ok(new ProfessionalRequestDTO(professional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity addProfessional(@RequestBody ProfessionalRequestDTO data) {
        Professional professional = new Professional(data);
        repository.save(professional);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Professional> updateProfessional(@PathVariable Long id, @RequestBody UpdateProfessionalDTO data) {
        Optional<Professional> optionalProfessional = repository.findById(id);

        if (optionalProfessional.isPresent()) {
            Professional professional = optionalProfessional.get();

            // Atualiza os dados do profissional
            professional.setFullName(data.fullName());
            professional.setEmail(data.email());
            professional.setPasswordHash(data.passwordHash());
            professional.setPhoneNumber(data.phoneNumber());
            professional.setSpecialty(data.specialty());

            // Salva o profissional atualizado
            repository.save(professional);

            // Retorna o profissional atualizado
            return ResponseEntity.ok(professional);
        } else {
            // Retorna resposta 404 caso o profissional não seja encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProfessional(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
