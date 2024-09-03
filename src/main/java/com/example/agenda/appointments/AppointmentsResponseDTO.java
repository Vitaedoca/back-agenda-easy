package com.example.agenda.appointments;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentsResponseDTO(
        Long appointmentsId,
        String userName,
        String professionalName,
        String serviceName,
        LocalDate appointmentDate,
        String status,
        String horario

        )
{
        public AppointmentsResponseDTO(Appointments data) {
                this(
                        data.getAppointmentsId(),
                        data.getUser().getFullName(),
                        data.getProfessional().getFullName(),
                        data.getService().getServiceName(),
                        data.getAppointmentDate(),
                        data.getStatus(),
                        data.getHorario()
                );
        }
}
