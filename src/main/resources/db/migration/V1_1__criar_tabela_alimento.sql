create table alimento(
    id serial not null,
    nome varchar(50) not null,
    descricao varchar(50) not null,
    categoria varchar(50) not null,
    preco numeric(4,2) not null,
    PRIMARY KEY(id),
    UNIQUE(nome)
);