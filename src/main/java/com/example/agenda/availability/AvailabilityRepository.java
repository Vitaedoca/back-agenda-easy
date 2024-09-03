package com.example.agenda.availability;

import com.example.agenda.appointments.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Appointments, Long> {}