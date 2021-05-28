create table categoria (
    id              bigint unsigned auto_increment,
    nome            varchar(30) NOT NULL,
    criado_em       datetime default CURRENT_TIMESTAMP,
    alterado_em     datetime default NULL on update CURRENT_TIMESTAMP,
    primary key (id),
    index index_nome (nome)
);