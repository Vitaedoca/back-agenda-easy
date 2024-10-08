package com.example.agenda.appointments;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AppointmentsRequestDTO(
        Long clientId,
        Long professionalId,
        Long serviceId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate appointmentDate,
        AppointmentStatus status,
        LocalTime horario
        )
{



}
