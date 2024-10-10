package com.example.agenda.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {}