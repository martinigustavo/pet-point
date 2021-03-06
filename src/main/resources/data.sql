-- Insert Permissoes
INSERT INTO public.permissao (id, descricao) VALUES(default, 'admin');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'veterinaria');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'petshop');

-- Insert Admin
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('admin', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'admin@email.com','Rua ABC, 1232, Centro','RS', false, 'Admin', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Masculino', 'Ativo', '(42) 11323-1321','funcionario', 'admin', NULL, 1);
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('veterinario', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'vet@email.com','Rua ABC, 1232, Centro','RS', false, 'Veterinaria', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Masculino', 'Ativo', '(42) 11323-1321','veterinario', 'veterinaria', '231344-23', 2);
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('caixa', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'pet@email.com','Rua ABC, 1232, Centro','RS', false, 'Petshop', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Feminino', 'Ativo', '(42) 11323-1321','funcionario', 'petshop', NULL, 3);

-- Insert Clientes
INSERT INTO public.cliente (cidade,cpf,data_cadastro,data_nascimento,email,endereco,estado,nome,sexo,status,telefone) VALUES ('Lajeado','123.131.321-31','2020-10-20','1998-10-20','cliente1@email.com','RS, 2131, RS','RS','Cliente 1','Feminino','Ativo','(23) 21321-3131');
INSERT INTO public.cliente (cidade,cpf,data_cadastro,data_nascimento,email,endereco,estado,nome,sexo,status,telefone) VALUES ('Lajeado','456.258.665-32','2021-01-20','1986-10-11','cliente2@email.com','RS, 2131, RS','RS','Cliente 2','Masculino','Ativo','(23) 21321-3131');
INSERT INTO public.cliente (cidade,cpf,data_cadastro,data_nascimento,email,endereco,estado,nome,sexo,status,telefone) VALUES ('Lajeado','159.753.286-45','2019-06-03','1990-10-11','cliente3@email.com','RS, 2131, RS','RS','Cliente 3','Feminino','Ativo','(23) 21321-3131');

-- Insert Especie
INSERT INTO public.especie (nome) VALUES('cachorro');
INSERT INTO public.especie (nome) VALUES('gato');

-- Insert Produto
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Alimentos',0.0,'Ossinho sabor picanha',10,'Osso',5.0,15.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Roupas',0.0,'Roupa para gato',10,'Roupa gato',10.0,20.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Higiene',0.0,'Sabonete para cachorro',10,'Sabonete',13.0,33.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Alimentos',0.0,'Petiscos para gatos',0,'Petiscos',2.0,8.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Alimentos',0.0,'Ra????o filhote',10,'Ra????o',50,85,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Higiene',0.0,'Shampoo antipulgas',10,'Shampoo',31.0,53.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Alimentos',0.0,'Ra????o adulto',10,'Ra????o',5.3,14.5,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Brinquedos',0.0,'Bolinha',10,'Bolinha',112,149.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Brinquedos',0.0,'Urso de pel??cia',10,'Pel??cia',24.0,57.0,'Ativo');
INSERT INTO public.produto (sku,categoria,desconto,descricao,estoque,nome,preco_custo,preco_venda,status) VALUES ('AAA123','Roupas',0.0,'Coleira cachorro',10,'Coleira',0.85,3.3,'Ativo');

-- Insert Ra??a
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'poodle', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'chihuahua', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'golden retriever', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'dachshund', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'boxer', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'labrador', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'shih-tzu', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'SRD', 1);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'SRD', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'persa', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'siam??s', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'siberiano', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'angor??', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'sphynx', 2);

-- Insert Pet
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Rex', 'm??dio', 'M', 1, 5);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Belinha', 'pequeno', 'F', 1, 2);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Fera', 'm??dio', 'F', 2, 1);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Gato', 'm??dio', 'M', 3, 10);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Thor', 'pequeno', 'M', 3, 8);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Lily', 'grande', 'F', 3, 3);

-- Insert Agenda
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-21', '11:30:00', '07:30:00', 'ativo', 2);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-22', '18:30:00', '13:30:00', 'ativo', 2);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-23', '11:30:00', '07:30:00', 'ativo', 3);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-24', '18:30:00', '13:30:00', 'ativo', 3);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-25', '11:30:00', '07:30:00', 'ativo', 3);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-26', '18:30:00', '13:30:00', 'ativo', 2);
INSERT INTO public.agenda ("data", horario_final, horario_inicio, status, funcionario_id) VALUES('2021-11-19', '18:30:00', '07:30:00', 'ativo', 3);

-- Insert Atendimento
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'Consulta', 'ativo', 1, 4);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('09:30:00', 'Receitado medicamentos', 'ativo', 1, 3);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('10:30:00', 'Banho e tosa', 'ativo', 1, 1);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('11:00:00', 'Consulta', 'ativo', 1, 5);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'Machucado', 'ativo', 7, 1);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('13:30:00', 'Banho', 'ativo', 7, 2);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('14:30:00', 'Tosa', 'ativo', 7, 3);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('09:30:00', 'Banho e escova', 'ativo', 7, 4);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'Consulta', 'ativo', 5, 5);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'Machucado', 'ativo', 5, 6);

-- Insert Venda
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-11-07',130.0), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1), ('2021-11-08',562.1);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-09-07',130.0), ('2021-09-08',562.1), ('2021-09-08',1785.0), ('2021-09-08',1785.0), ('2021-09-08',1785.0), ('2021-09-08',1785.0), ('2021-09-08',1785.0), ('2021-09-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-08-07',130.0), ('2021-08-07',130.0), ('2021-08-07',130.0), ('2021-08-08',562.1), ('2021-08-08',569.0), ('2021-08-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-07-07',130.0), ('2021-07-07',130.0),('2021-07-07',130.0), ('2021-07-07',130.0), ('2021-07-08',562.1), ('2021-07-08',562.1), ('2021-07-08',569.0), ('2021-07-08',562.1);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-06-07',130.0), ('2021-06-07',130.0),('2021-06-07',130.0), ('2021-06-07',130.0), ('2021-06-08',562.1), ('2021-06-08',562.1), ('2021-06-08',569.0), ('2021-06-08',562.1), ('2021-06-08',569.0), ('2021-06-08',569.0), ('2021-06-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-05-07',130.0), ('2021-05-07',130.0),('2021-05-07',130.0), ('2021-05-07',130.0), ('2021-05-08',562.1), ('2021-05-08',569.0), ('2021-05-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-04-07',130.0), ('2021-04-07',130.0),('2021-04-07',130.0), ('2021-04-07',130.0), ('2021-04-08',562.1), ('2021-04-08',569.0), ('2021-04-08',1785.0), ('2021-04-08',1785.0), ('2021-04-08',1785.0), ('2021-04-08',1785.0), ('2021-04-08',1785.0), ('2021-04-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-03-07',130.0), ('2021-03-07',130.0),('2021-03-07',130.0), ('2021-03-07',130.0), ('2021-03-08',562.1), ('2021-03-08',569.0), ('2021-03-08',1785.0), ('2021-03-08',1785.0), ('2021-03-08',1785.0), ('2021-03-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-02-07',130.0), ('2021-02-07',130.0),('2021-02-07',130.0), ('2021-02-07',130.0), ('2021-02-08',562.1), ('2021-02-08',569.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0), ('2021-02-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2021-01-07',130.0), ('2021-01-07',130.0),('2021-01-07',130.0), ('2021-01-07',130.0), ('2021-01-08',562.1), ('2021-01-08',569.0), ('2021-01-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2020-12-07',130.0), ('2020-12-07',130.0),('2020-12-07',130.0), ('2020-12-07',130.0), ('2020-12-08',562.1), ('2020-12-08',569.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0), ('2020-12-08',1785.0);
INSERT INTO public.venda (data_venda,valor_total) VALUES ('2020-11-07',130.0), ('2020-11-07',130.0),('2020-11-07',130.0), ('2020-11-07',130.0), ('2020-11-08',562.1), ('2020-11-08',569.0), ('2020-11-08',1785.0), ('2020-11-08',1785.0), ('2020-11-08',1785.0);

-- Trigger Audit
CREATE OR REPLACE FUNCTION INSERT_LOG() RETURNS trigger LANGUAGE plpgsql as $$ DECLARE v_old_data TEXT; v_new_data TEXT; BEGIN if (TG_OP = 'UPDATE') then v_old_data := ROW(OLD.*); v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, v_old_data, (select id from funcionario where logado = true)); RETURN NEW; elsif (TG_OP = 'DELETE') then v_old_data := ROW(OLD.*); insert into LOG (id, tabela, comando, data, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_old_data, (select id from funcionario where logado = true)); RETURN OLD; elsif (TG_OP = 'INSERT') then v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, (select id from funcionario where logado = true)); RETURN NEW; else RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now(); RETURN NULL; end if; END; $$

--Log usu??rio
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON AGENDA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON ATENDIMENTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON CAIXA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON CLIENTE FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON ESPECIE FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR DELETE ON FUNCIONARIO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PESO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PET FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PRODUTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON RACA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON SERVICO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON VENDA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();       