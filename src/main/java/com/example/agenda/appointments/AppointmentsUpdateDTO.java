package com.example.agenda.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AppointmentsUpdateDTO(
        Long appointmentsId,
        LocalDate appointmentDate,
        AppointmentStatus status,
        LocalTime horario
) {
}
