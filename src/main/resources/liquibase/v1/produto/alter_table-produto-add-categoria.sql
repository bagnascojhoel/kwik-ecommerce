alter table produto
    add column categoria_id bigint unsigned;

alter table produto
    add constraint fk_categoria_id
    foreign key(categoria_id)
    references categoria(id)