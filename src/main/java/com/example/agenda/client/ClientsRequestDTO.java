package com.example.agenda.client;

import com.example.agenda.role.Role;

public record ClientsRequestDTO(String name, String phone, String photo, String status, String email, String password, Role roles) {
}
