package com.example.agenda.controller;


import com.example.agenda.admin.Admin;
import com.example.agenda.admin.AdminRepository;
import com.example.agenda.client.ClientRepository;
import com.example.agenda.professional.Professional;
import com.example.agenda.professional.ProfessionalRepository;
import com.example.agenda.services.ServiceRepository;
import com.example.agenda.services.Services;
import com.example.agenda.time.Times;
import com.example.agenda.time.TimesRepository;
import com.example.agenda.time.TimesRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/times")
public class TimesController {

    @Autowired
    private TimesRepository repository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity getAll() {
        var allTimes = repository.findAll();
        return ResponseEntity.ok(allTimes);
    }

    @PostMapping
    public ResponseEntity createTimes(@RequestBody TimesRequestDTO data) {
        Admin admin = adminRepository.findById(data.adminId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));

        Services service = serviceRepository.findById(data.serviceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found"));

        Professional professional = professionalRepository.findById(data.professionalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professional not found"));

        // Use o construtor correto com Service e Professional
        Times times = new Times(data, admin, service, professional);

        repository.save(times);
        return ResponseEntity.ok().build();
    }

}
