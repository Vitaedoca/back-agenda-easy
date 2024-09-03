package com.example.agenda.appointments;


import com.example.agenda.professional.Professional;
import com.example.agenda.services.Services;
import com.example.agenda.user.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "appointments")
@Entity(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "appointmentsId")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentsId;

    @ManyToOne
    @JoinColumn(name = "userId")  // Define a chave estrangeira para o usuário
    @JsonIgnore
    private Users user;

    @ManyToOne
    @JoinColumn(name = "professionalId")  // Define a chave estrangeira para o profissional
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "serviceId")  // Define a chave estrangeira para o serviço
    private Services service;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;

    private String status;
    private String createdAt;
    private String horario;

    public Appointments(AppointmentsRequestDTO data, Users user, Professional professional, Services service) {
        this.user = user;
        this.professional = professional;
        this.service = service;
        this.appointmentDate = data.appointmentDate();
        this.status = data.status();
        this.horario = data.horario();
    }
}
