package com.example.agenda.services;


import com.example.agenda.admin.Admin;
import com.example.agenda.professional.Professional;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "service")
@Entity(name = "service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "serviceId")

public class Services {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;
    private String photo;
    private String description;
    private Integer duration;
    private Double price;

//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Admin> admin;
//
//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Professional> professional;

    public Services(ServiceRequestDTO data) {
        this.serviceId = data.serviceId();
        this.serviceName = data.serviceName();
        this.photo = data.photo();
        this.description = data.description();
        this.duration = data.duration();
        this.price = data.price();
    }
}
