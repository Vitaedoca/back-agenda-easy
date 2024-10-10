package com.example.agenda.professional;

public record ProfessionalRequestDTO(
        Long professionalId,
        String fullName,
        String email,
        String passwordHash,
        String phoneNumber
) {

    // Construtor para criar DTO a partir de um objeto Professional
    public ProfessionalRequestDTO(Professional professional) {
        this(
                professional.getProfessionalId(),
                professional.getFullName(),
                professional.getEmail(),
                professional.getPasswordHash(),
                professional.getPhoneNumber()
        );
    }
}
