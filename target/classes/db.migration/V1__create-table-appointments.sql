CREATE TABLE appointments (
    appointmentsId TEXT PRIMARY KEY,
    userId TEXT NOT NULL,
    professionalId TEXT NOT NULL,
    serviceId TEXT NOT NULL,
    appointmentDate TIMESTAMP NOT NULL,
    status TEXT CHECK (Status IN ('Agendado', 'Concluído', 'Cancelado')) DEFAULT'Agendado',
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE,
    FOREIGN KEY (professionalId) REFERENCES professional(professionalId) ON DELETE SET NULL,
    FOREIGN KEY (serviceId) REFERENCES service(serviceId) ON DELETE CASCADE
);