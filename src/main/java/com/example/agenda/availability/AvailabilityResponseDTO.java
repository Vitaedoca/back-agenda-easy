package com.example.agenda.availability;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityResponseDTO(
        Long availabilityId,
        Long professionalId,
        LocalDate availableDate,
        LocalTime startTime,
        LocalTime endTime
) {
}
