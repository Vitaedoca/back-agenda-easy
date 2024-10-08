package com.example.agenda.appointments;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AppointmentsResponseDTO(
        Long appointmentsId,
        String userName,
        String professionalName,
        String serviceName,
        LocalDate appointmentDate,
        AppointmentStatus status,
        LocalTime horario

        )
{
        public AppointmentsResponseDTO(Appointments data) {
                this(
                        data.getAppointmentsId(),
                        data.getClient().getName(),
                        data.getProfessional().getFullName(),
                        data.getService().getServiceName(),
                        data.getAppointmentDate(),
                        data.getStatus(),
                        data.getHorario()
                );
        }
}
