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
INSERT INTO public.especie (nome) VALUES('cão');
INSERT INTO public.especie (nome) VALUES('gato');

-- Insert Raça
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
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'siamês', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'siberiano', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'angorá', 2);
INSERT INTO public.raca (id, nome, especie_id) VALUES(default, 'sphynx', 2);

-- Insert Pet
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Rex', 'médio', 'M', 1, 5);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Belinha', 'pequeno', 'F', 1, 2);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Fera', 'médio', 'F', 2, 1);
INSERT INTO public.pet (data_cadastro, data_nascimento, esterilizado, nome, porte, sexo, cliente_id, raca_id) VALUES('2021-03-02', '2018-08-12', true, 'Gato', 'médio', 'M', 3, 10);
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
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'asdsadweqeqweq', 'ativo', 1, 4);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('09:30:00', 'wqewqdsadsad', 'ativo', 1, 3);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('10:30:00', 'gdsgdsgdsgs', 'ativo', 1, 1);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('11:00:00', '2eeqwedqwsdsad', 'ativo', 1, 5);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', 'dsadsadsad', 'ativo', 7, 1);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('13:30:00', 'xgdgsdg', 'ativo', 7, 2);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('14:30:00', 'dsgfhfhfde', 'ativo', 7, 3);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('09:30:00', 'fdsdfsdfdsf', 'ativo', 7, 4);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', '434324r3252', 'ativo', 5, 5);
INSERT INTO public.atendimento (hora, observacoes, status, agenda_id, pet_id) VALUES('08:30:00', '432423432432', 'ativo', 5, 6);


-- Trigger Audit
CREATE OR REPLACE FUNCTION INSERT_LOG() RETURNS trigger LANGUAGE plpgsql as $$ DECLARE v_old_data TEXT; v_new_data TEXT; BEGIN if (TG_OP = 'UPDATE') then v_old_data := ROW(OLD.*); v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, v_old_data, (select id from funcionario where logado = true)); RETURN NEW; elsif (TG_OP = 'DELETE') then v_old_data := ROW(OLD.*); insert into LOG (id, tabela, comando, data, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_old_data, (select id from funcionario where logado = true)); RETURN OLD; elsif (TG_OP = 'INSERT') then v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, (select id from funcionario where logado = true)); RETURN NEW; else RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now(); RETURN NULL; end if; END; $$

--Log usuário
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