create table pedido (
	id_pedido int not null primary key auto_increment,
	dt_pedido date,
	total int,
	status varchar(20),
	id_cliente int
);

create table produto (
	id_produto int not null primary key auto_increment,
	nm_produto varchar(150),
	preco decimal(10,2),
	estoque int,
	id_categoria int
);

create table forma_pagamento (
	id_forma int not null primary key auto_increment,
	forma_pagamento varchar(50)
);

create table categoria (
	id_categoria int primary key not null auto_increment,
	tipo_categoria varchar(50)
);