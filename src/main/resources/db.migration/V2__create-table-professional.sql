CREATE TABLE professional  (
    professionalId TEXT PRIMARY KEY UNIQUE NOT NULL,
    fullName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    passwordHash TEXT NOT NULL,
    phoneNumber TEXT,
    specialty TEXT,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);