package com.example.agenda.availability;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityRequestDTO(
        Long availabilityId,
        Long professionalId,
        LocalDate availableDate,
        LocalTime startTime,
        LocalTime endTime
) {
}
