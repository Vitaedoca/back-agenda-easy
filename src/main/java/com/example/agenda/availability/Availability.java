package com.example.agenda.availability;


import com.example.agenda.professional.Professional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "availability")
@Entity(name = "availability")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "availabilityId")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    @ManyToOne
    @JoinColumn(name = "professionalId")  // Define a chave estrangeira para o usuário
    @JsonIgnore
    private Professional professional;
    private LocalDate availableDate;
    private LocalTime startTime;
    private LocalTime endTime;


    public Availability(AvailabilityRequestDTO data, Professional professional) {
        this.professional = professional;
        this.availableDate = data.availableDate();
        this.startTime = data.startTime();
        this.endTime = data.endTime();
    }
}
