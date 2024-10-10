CREATE TABLE users (
    userId TEXT PRIMARY KEY UNIQUE NOT NULL,
    fullName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    phoneNumber TEXT,
    passwordHash TEXT NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);