create table produto (
    id              bigint unsigned auto_increment,
    titulo          varchar(100) not null,
    preco_unitario  decimal(7,2) not null,
    qtd_disponivel  smallint unsigned default 0,
    descricao text  default null,
    categoria_id    bigint unsigned not null,
    criado_em       datetime default current_timestamp,
    alterado_em     datetime default null on update current_timestamp,
    primary key (id),
    index index_titulo (titulo),
    foreign key (categoria_id) references categoria(id)
);
