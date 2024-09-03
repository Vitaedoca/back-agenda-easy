package com.example.agenda.controller;

import com.example.agenda.services.ServiceRepository;
import com.example.agenda.services.ServiceRequestDTO;
import com.example.agenda.services.Services;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository repository;

    @GetMapping
    public ResponseEntity getAllService() {
        var allService = repository.findAll();
        return ResponseEntity.ok(allService);
    }

    @PostMapping
    public ResponseEntity addService(@RequestBody ServiceRequestDTO data) {
        Services service = new Services(data);
        repository.save(service);
        return ResponseEntity.ok(service);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Services> updateService(
            @PathVariable("id") Long id,
            @RequestBody ServiceRequestDTO data) {

        Optional<Services> optionalService = repository.findById(id);

        if (optionalService.isPresent()) {
            Services service = optionalService.get();
            service.setServiceName(data.serviceName());
            service.setDescription(data.description());
            service.setDuration(data.duration());
            service.setPrice(data.price());
            repository.save(service); // Save the updated service
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteService(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
