package com.example.agenda.time;

import java.time.LocalDateTime;
import java.util.Date;

public record TimesRequestDTO(
        Long adminId,
        Long serviceId,
        Long professionalId,
        Integer days,
        LocalDateTime start,
        LocalDateTime end
) {
}
