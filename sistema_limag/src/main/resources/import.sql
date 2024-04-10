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


INSERT INTO tb_email_funcionarios (employee_id, emails) VALUES (1,'email@teste.com')
INSERT INTO tb_email_funcionarios (employee_id, emails) VALUES (1,'email2@teste.com')
INSERT INTO tb_email_funcionarios (employee_id, emails) VALUES (2,'email3@teste.com')
INSERT INTO tb_email_funcionarios (employee_id, emails) VALUES (4,'email4@teste.com')

 INSERT INTO tb_grupo_clientes (name) VALUES ('CCR');
 INSERT INTO tb_grupo_clientes (name) VALUES ('CSN');
 INSERT INTO tb_grupo_clientes (name) VALUES ('ARCELOR');
 INSERT INTO tb_grupo_clientes (name) VALUES ('GERDAU');
 INSERT INTO tb_grupo_clientes (name) VALUES ('VOITH');

 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (1,'CCR São Paulo' ,'Linha 8 e 9');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (1,'CCR São Paulo' ,'Via Mobilidade');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (2,'Av. Brig. Faria Lima, 3400' ,'CSN Companhia Siderurgica Nacional');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (3,'R. Romeu Cicarelli, 70 - Vila Alice, Diadema - SP' ,'ARCELORMITTAL');
 INSERT INTO tb_clientes(client_group_id,address,name) VALUES (4,' Av. Mal. Mascarenhas de Morais, 1736' ,'GERDAU RECIFE PE');

 INSERT INTO tb_compradores(client_group_id,name,origin, email,phone_number) VALUES(5,'ABNER SANTOS','VENDAS','abner.santos@voith.com','(11)3944-4962');
 INSERT INTO tb_compradores(client_group_id,name,origin, email,phone_number) VALUES(5,'ALEX AQUINO','VENDAS','Alex.Aquino@voith.com','(11)91555-5269');
 INSERT INTO tb_compradores(client_group_id,name,origin, email,phone_number) VALUES(3,'ANDRE JUNIOR','PROSPECÇÃO','andre.junior@arcelormittal.com.br','(27)3348-3865');

 -- '1992-03-10'

 INSERT INTO tb_compradores_por_vendedores(pote,reference_date,purchaser_id,seller_id) VALUES (3,'2024-02-01',2,2 );
 INSERT INTO tb_compradores_por_vendedores(pote,reference_date,purchaser_id,seller_id) VALUES (2,'2024-01-01',2,2 );
 INSERT INTO tb_compradores_por_vendedores(pote,reference_date,purchaser_id,seller_id) VALUES (1,'2023-12-01',2,2 );
 INSERT INTO tb_compradores_por_vendedores(pote,reference_date,purchaser_id,seller_id) VALUES (1,'2024-02-01',3,1 );