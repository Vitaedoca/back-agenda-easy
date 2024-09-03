package com.example.agenda.admin;

public record AdminResponseDTO(
        String fullName,
        String email
) {
    public AdminResponseDTO(Admin data) {
        this(
                data.getFullName(),
                data.getEmail()
        );
    }
}
