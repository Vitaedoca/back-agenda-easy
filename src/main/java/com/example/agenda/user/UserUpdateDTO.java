package com.example.agenda.user;

import com.example.agenda.role.Role;

public record UserUpdateDTO(Long userId, String fullName, String phoneNumber, String email, String passwordHash, Role role) {
}
