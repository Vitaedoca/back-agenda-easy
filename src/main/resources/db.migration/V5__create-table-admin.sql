CREATE TABLE admin (
    adminId LONG PRIMARY KEY UNIQUE NOT NULL,
    fullName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    passwordHash TEXT NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
