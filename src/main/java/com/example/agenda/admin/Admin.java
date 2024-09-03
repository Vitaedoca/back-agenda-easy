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
    private String fullName;
    private String email;
    private String passwordHash;


    public Admin(AdminRequestDTO data) {
        this.fullName = data.fullName();
        this.email = data.email();
        this.passwordHash = data.passwordHash();
    }
}
