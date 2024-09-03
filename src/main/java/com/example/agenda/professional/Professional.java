package com.example.agenda.professional;


import com.example.agenda.appointments.Appointments;
import com.example.agenda.availability.Availability;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name="professional")
@Entity(name="professional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="professionalId")
public class Professional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionalId;
    private String fullName;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private String specialty;
    private String createdAt;

//    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Appointments> appointments;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Availability> availability;

    public Professional(ProfessionalRequestDTO data) {
        this.professionalId = data.professionalId();
        this.fullName = data.fullName();
        this.email = data.email();
        this.passwordHash = data.passwordHash();
        this.specialty = data.specialty();
    }
}
