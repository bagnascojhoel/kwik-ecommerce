create table `product` (
    `id` bigint unsigned auto_increment,
    `titulo` varchar(100) NOT NULL,
    `preco_unitario` decimal(7,2) NOT NULL,
    `qtd_disponivel` smallint unsigned default 0,
    `descricao` text default NULL,
    `criado_em` datetime default CURRENT_TIMESTAMP,
    `alterado_em` datetime default NULL on update CURRENT_TIMESTAMP,
    primary key (`id`),
    index `index_titulo` (`titulo`)
);
