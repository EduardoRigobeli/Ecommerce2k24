insert into forma_pagamento (id_forma, forma_pagamento)
values (1, 'Pix'),
(2, 'Cartão de Credito/Debito'),
(3, 'Parcelamento'),
(4, 'Boleto Bancario');

insert into categoria (id_categoria, tipo_categoria)
values (1, 'Audio e Video'),
(2, 'Games'),
(3, 'Computador'),
(4, 'Drones'),
(5, 'Celulares e Smartphones'),
(6, 'Smartwatchs'),
(7, 'Promoções');

insert into produto (id_produto, nm_produto, preco, estoque, id_categoria)
values (1, 'Headset JBL TUNE 770C', 299.99, 200, 1),
(2, 'Echo pop Smart Speak Alexa', 189.99, 100, 1),
(3, 'Notebook Samsung Book4', 2099.99, 80, 3),
(4, 'Iphone 16 Branco 16 GB - 8 GB RAM', 3509.99, 20, 5),
(5, 'Echo Dot A5 Smart Speak Alexa', 209.99, 90, 1),
(6, 'Caixa JBL Flip 5 preta', 199.99, 90, 1),
(7, 'Caixa de Som JBL Partybox 110', 3509.99, 100, 1),
(8, 'Moto G34 Azul 256GB 16GB Ram', 889.99, 150, 5),
(9, 'Caixa JBL Flip 5 preta', 189.99, 250, 1),
(10, 'Smartwatch Xiaomi Band 8 Active', 229.99, 180, 6),
(11, 'Smartwatch Galaxy Watch7', 989.99, 180, 6),
(12, 'Smartwatch Galaxy Watch Ultra', 1099.99, 180, 6),
(13, 'Playstation 5 Pro 1TB Branco', 3299.99, 100, 2),
(14, 'Projetor Smart Cinema Full HD', 489.99, 100, 1),
(15, 'Playstation 4 Pro 1TB Preto', 1089.99, 100, 2),
(16, 'Drone FPV com câmera 4K atualizada', 129.99, 200, 4),
(17, 'Projetor Smart Cinema Full HD', 99.99, 150, 1),
(18, 'Console Xbox Series S 1TB Branco', 1599.99, 200, 2),
(19, 'Mini Projetor Portátil 4K 1080P Full HD', 129.99, 150, 1),
(20, 'Console Xbox Series X 1TB SSD', 2029.99, 100, 2),
(21, 'Drone câmera Dupla 4K preto', 189.99, 150, 4);