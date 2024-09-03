package com.example.agenda.user;

public record UserUpdateDTO(Long userId, String fullName, String phoneNumber, String email, String passwordHash) {
}
