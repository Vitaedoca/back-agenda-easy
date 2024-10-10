package com.example.agenda.client;

import com.example.agenda.role.Role;

public record ClientUpdateDTO(Long id, String name, String phone, String photo, String status, String email, String password, Role role) {
}
