create table produtos
(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(100) not null,
    preco double,
    fabricante varchar(50),

    primary key(id)
);