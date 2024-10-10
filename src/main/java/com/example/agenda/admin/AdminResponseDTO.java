package com.example.agenda.admin;

public record AdminResponseDTO(
        Long adminId,
        String name,
        String phone,
        String photo,
        String coverPhoto,
        String status,
        String email
) {
    public AdminResponseDTO(Admin data) {
        this(
                data.getAdminId(),
                data.getName(),
                data.getPhone(),
                data.getPhoto(),
                data.getCoverPhoto(),
                data.getStatus(),
                data.getEmail()
        );
    }
}
