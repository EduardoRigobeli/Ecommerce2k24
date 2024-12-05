 create table categoria (
 	id_categoria int primary key not null,
 	tipo_categoria varchar(50)
 );

 create table produto (
 	id_produto int not null primary key,
 	nm_produto varchar(150),
 	preco decimal(10,2),
 	estoque int,
 	id_categoria int,
 	foreign key (id_categoria) references categoria (id_categoria)
 );

 create table pedido (
 	id_pedido int not null primary key auto_increment,
 	id_produto int,
 	dt_pedido date,
 	total_pagar int,
 	qtd_produto int,
 	status varchar(20),
 	foreign key (id_produto) references produto (id_produto)
 );

 create table forma_pagamento (
 	id_forma int not null primary key,
 	forma_pagamento varchar(50)
 );

 create table pagamento (
 	id_pedido int,
 	id_forma int,
 	valor_pagar decimal(10,2),
 	foreign key (id_pedido) references pedido (id_pedido),
 	foreign key (id_forma) references forma_pagamento (id_forma)
 );

 create table item_pedido (
 	id_produto int,
 	id_pedido int,
 	foreign key (id_produto) references produto (id_produto),
 	foreign key (id_pedido) references pedido (id_pedido)
 );

 create table audit_preco_produto (
 	id_audit int primary key not null auto_increment,
 	id_produto int,
 	dt_modificacao date,
 	preco_antigo decimal(10,2),
 	preco_novo decimal(10,2),
 	motivo varchar(10),
 	foreign key (id_produto) references produto (id_produto)
 );