CREATE DATABASE mp06uf04;

CREATE TABLE tickets (
    id SERIAL PRIMARY KEY,
    title TEXT
);

CREATE TABLE TicketsUser (
    mail TEXT
) INHERITS (tickets);

CREATE TABLE ticketsLogs (
    application TEXT
) INHERITS (tickets);