package com.example.agenda.professional;

public record UpdateProfessionalDTO(
        String fullName,
        String email,
        String passwordHash,
        String specialty
) {}