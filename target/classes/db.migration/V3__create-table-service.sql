CREATE TABLE service (
    serviceId TEXT PRIMARY KEY UNIQUE NOT NULL,
    serviceName TEXT NOT NULL,
    description TEXT NOT NULL,
    duration INT NOT NULL,
    price DECIMAL(10, 2)
);