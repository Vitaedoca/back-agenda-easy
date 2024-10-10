package com.example.agenda.admin;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "admin")
@Entity(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "adminId")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String name;
    private String photo;
    private String coverPhoto;
    private String phone;
    private String status;
    private String email;
    private String password;


    public Admin(AdminRequestDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }
}
