create table produto_foto (
    produto_id  bigint unsigned not null,
    url varchar(200) not null,
    primary key (produto_id),
    foreign key (produto_id) references produto(id)
)