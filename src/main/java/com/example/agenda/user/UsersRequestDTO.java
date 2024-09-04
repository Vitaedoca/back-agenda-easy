package com.example.agenda.user;

import com.example.agenda.role.Role;

public record UsersRequestDTO(String fullName, String phoneNumber, String email, String passwordHash, Role roles) {
}
