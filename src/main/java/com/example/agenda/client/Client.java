package com.example.agenda.client;


import com.example.agenda.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Table(name = "client")
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String photo;
    private String status;
    private String email;
    private String password;
    private String createdAt;

//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Appointments> appointments;

    public Client(ClientsRequestDTO data) {
        this.name = data.name();
        this.phone = data.phone();
        this.photo = data.photo();
        this.status = data.status();
        this.email = data.email();
        this.password = data.password();
    }

}
