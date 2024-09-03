CREATE TABLE availability (
    availabilityId LONG PRIMARY KEY UNIQUE NOT NULL,
    professionalId LONG NOT NULL,
    availableDate DATE NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    FOREIGN KEY (professionalId) REFERENCES professional(professionalId) ON DELETE CASCADE,
    UNIQUE (professionalId, availableDate, startTime)  -- Garante que não haja horários duplicados
);