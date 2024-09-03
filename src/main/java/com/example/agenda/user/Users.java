package com.example.agenda.user;


import com.example.agenda.appointments.Appointments;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "userId")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String passwordHash;
    private String createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointments> appointments;

    public Users(UsersRequestDTO data) {
        this.fullName = data.fullName();
        this.phoneNumber = data.phoneNumber();
        this.email = data.email();
        this.passwordHash = data.passwordHash();
    }
}
