package com.example.agenda.admin;

public record AdminRequestDTO(
        Long adminId,
        String fullName,
        String email,
        String passwordHash
) {
}
