package com.example.agenda.services;


import jakarta.persistence.*;
import lombok.*;

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
    private String description;
    private Integer duration;
    private Double price;

//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Appointments> appointments;

    public Services(ServiceRequestDTO data) {
        this.serviceId = data.serviceId();
        this.serviceName = data.serviceName();
        this.description = data.description();
        this.duration = data.duration();
        this.price = data.price();
    }
}
