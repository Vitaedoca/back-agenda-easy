package com.example.agenda.services;

public record ServiceRequestDTO (
        Long serviceId,
        String serviceName,
        String description,
        Integer duration,
        Double price)
{

}
