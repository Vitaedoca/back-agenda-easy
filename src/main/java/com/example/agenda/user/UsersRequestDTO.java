package com.example.agenda.user;

public record UsersRequestDTO(String fullName, String phoneNumber, String email,  String passwordHash) {
}
