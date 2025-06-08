CREATE TABLE IF NOT EXISTS empresas (
    id serial PRIMARY KEY,
    cnpj varchar(14),
    nome varchar(50),
    email varchar(20),
    telefone varchar(20),
    endereco varchar(50)
);