package com.example.agenda.appointments;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentsRequestDTO(
        Long userId,
        Long professionalId,
        Long serviceId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate appointmentDate,
        String status,
        String horario
        )
{



}
