package com.example.agenda.appointments;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeSlotGenerator {

    public List<LocalTime> generateTimeSlots(LocalTime startTime, LocalTime endTime, int intervalMinutes) {
        List<LocalTime> slots = new ArrayList<>();
        LocalTime time = startTime;

        while (time.isBefore(endTime)) {
            slots.add(time);
            time = time.plusMinutes(intervalMinutes);
        }

        return slots;
    }
}
