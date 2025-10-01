CREATE TABLE movie
(
    id       BIGSERIAL PRIMARY KEY,
    title    VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    fees     REAL,
    genre    VARCHAR(70)
);
