DROP DATABASE IF EXISTS rede_social;
CREATE DATABASE IF NOT EXISTS rede_social;
USE rede_social;

CREATE TABLE IF NOT EXISTS Usuario (
	id_usuario INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_usuario)
);

CREATE TABLE IF NOT EXISTS Postagem (
    id_postagem INT NOT NULL AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    texto TEXT NOT NULL,
    data_postagem TIMESTAMP,
    PRIMARY KEY(id_postagem),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
);