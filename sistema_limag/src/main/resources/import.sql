-- VENDAS,LOGISTICA,TECNOLOGIA,ADMINISTRATIVO,DIRETORIA,COMPRAS;

 --    SUPPORT, JUNIOR, SPECIALIST;
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Wellington Gomes', '1990-05-15', 5000.00, 'CLT', 'VENDAS');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Eduardo Mehnes', '1985-09-20', 5000.00, 'PJ','VENDAS');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Wallace Gomes', '1992-03-10', 4500.00, 'CLT','VENDAS');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Bruno', '1992-03-10', 3500.00, 'CLT', 'LOGISTICA');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Marcos', '1992-03-10', 2500.00, 'CLT','VENDAS');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Eduardo Soares', '1992-03-10', 2500.00, 'CLT','TECNOLOGIA');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('David Vincent', '1992-03-10', 1500.00, 'CLT', 'TECNOLOGIA');
INSERT INTO tb_funcionarios (name, birth_date, salary, contract_type, department) VALUES ('Camilly', '1992-03-10', 1900.00, 'CLT', 'COMPRAS');


INSERT INTO tb_vendedores (id, seller_nivel, squad) VALUES (1,'JUNIOR','SPIDER JR');
INSERT INTO tb_vendedores (id, seller_nivel, squad) VALUES (2,'SPECIALIST','FORMIGUEIRO');
INSERT INTO tb_vendedores (id, seller_nivel, squad) VALUES (3,'SPECIALIST','ESPARTANOS');
INSERT INTO tb_vendedores (id, seller_nivel, squad) VALUES (5,'SUPPORT','APOIO');


 INSERT INTO tb_grupo_clientes (name) VALUES ('CCR');
 INSERT INTO tb_grupo_clientes (name) VALUES ('CSN');
 INSERT INTO tb_grupo_clientes (name) VALUES ('ARCELOR');
 INSERT INTO tb_grupo_clientes (name) VALUES ('GERDAU');

 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (1,'CCR São Paulo' ,'Linha 8 e 9');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (1,'CCR São Paulo' ,'Via Mobilidade');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (2,'Av. Brig. Faria Lima, 3400' ,'CSN Companhia Siderurgica Nacional');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (3,'R. Romeu Cicarelli, 70 - Vila Alice, Diadema - SP' ,'ARCELORMITTAL');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (4,' Av. Mal. Mascarenhas de Morais, 1736' ,'GERDAU RECIFE PE');