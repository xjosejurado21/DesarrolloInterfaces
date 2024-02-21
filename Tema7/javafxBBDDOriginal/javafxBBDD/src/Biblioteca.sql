DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libro(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(100),
    editorial VARCHAR(100),
    autor VARCHAR(100),
    paginas INT
);