package com.example.agenda.controller;

import com.example.agenda.appointments.*;
import com.example.agenda.client.Client;
import com.example.agenda.professional.Professional;
import com.example.agenda.professional.ProfessionalRepository;
import com.example.agenda.services.ServiceRepository;
import com.example.agenda.services.Services;
import com.example.agenda.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsRepository repository;

    @Autowired
    private ClientRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping
    public ResponseEntity getAllAppointments() {

        List<AppointmentsResponseDTO> list = repository.findAll().stream().map(AppointmentsResponseDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity addAppointments(@RequestBody AppointmentsRequestDTO data) {
        Client client = userRepository.findById(data.clientId()).orElseThrow(() -> new RuntimeException("Not encontrei"));
        Professional professional = professionalRepository.findById(data.professionalId()).orElseThrow(() -> new RuntimeException("Não encontrei"));
        Services service = serviceRepository.findById(data.serviceId()).orElseThrow(() -> new RuntimeException("Não encontrei"));

        Appointments appointments = new Appointments(data, client, professional, service);
        repository.save(appointments);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    @Transactional
    public ResponseEntity updateAppointments(@RequestBody AppointmentsUpdateDTO data) {

        Optional<Appointments> ByAppointments = repository.findById(data.appointmentsId());

        if(ByAppointments.isPresent()) {
            Appointments appointments = ByAppointments.get();
            appointments.setAppointmentDate(data.appointmentDate());
            appointments.setStatus(data.status());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppointments(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
