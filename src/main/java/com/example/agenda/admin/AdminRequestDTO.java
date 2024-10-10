package com.example.agenda.admin;

public record AdminRequestDTO(
        Long adminId,
        String name,
        String phone,
        String photo,
        String coverPhoto,
        String status,
        String email,
        String password
) {
}
