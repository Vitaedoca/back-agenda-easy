package com.example.agenda.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentsUpdateDTO(
        Long appointmentsId,
        LocalDate appointmentDate,
        String status,
        String horario
) {
}
