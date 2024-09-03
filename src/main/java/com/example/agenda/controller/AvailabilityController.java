package com.example.agenda.controller;


import com.example.agenda.availability.Availability;
import com.example.agenda.availability.AvailabilityRepository;
import com.example.agenda.availability.AvailabilityRequestDTO;
import com.example.agenda.availability.AvailabilityUpdateDTO;
import com.example.agenda.professional.Professional;
import com.example.agenda.professional.ProfessionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityRepository repository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping
    public ResponseEntity allAvailability() {
//        List<AvailabilityResponseDTO> list =
        var list = repository.findAll();
        return ResponseEntity.ok(list);
    }

//    @PostMapping
//    public ResponseEntity createAvailability(@RequestBody AvailabilityRequestDTO data) {
//        Professional professional = professionalRepository.findById(data.professionalId()).orElseThrow(() -> new RuntimeException("Não enontrei"));
//
//        Availability availability = new Availability(data, professional);
//
//        repository.save(availability);
//        return ResponseEntity.ok(availability);
//    }

//    @PutMapping
//    @Transactional
//    public ResponseEntity updateAvailability(@RequestBody AvailabilityUpdateDTO data) {
//        Optional<Availability> optionalAvailability = repository.findById(data.availabilityId());
//
//        Professional professional = professionalRepository.findById(data.professionalId()).orElseThrow(() -> new RuntimeException("Não encontrado"));
//
//        if(optionalAvailability.isPresent()) {
//            Availability availability = optionalAvailability.get();
//            availability.setProfessional(professional);
//            availability.setAvailableDate(data.availableDate());
//            availability.setStartTime(data.startTime());
//            availability.setEndTime(data.endTime());
//            return ResponseEntity.ok(availability);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAvailability(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
