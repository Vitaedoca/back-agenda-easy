package com.example.agenda.appointments;


import com.example.agenda.client.Client;
import com.example.agenda.professional.Professional;
import com.example.agenda.services.Services;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    @JoinColumn(name = "client_id")  // Define a chave estrangeira para o usuário
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "professionalId")  // Define a chave estrangeira para o profissional
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "serviceId")  // Define a chave estrangeira para o serviço
    private Services service;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate appointmentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(nullable = false)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;



    public Appointments(AppointmentsRequestDTO data, Client client, Professional professional, Services service) {
        this.client = client;
        this.professional = professional;
        this.service = service;
        this.appointmentDate = data.appointmentDate();
        this.status = data.status();
        this.horario = data.horario();
    }
}
