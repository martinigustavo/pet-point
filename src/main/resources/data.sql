-- Insert Permissoes
INSERT INTO public.permissao (id, descricao) VALUES(default, 'admin');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'veterinaria');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'petshop');

-- Insert Admin
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('admin', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'admin@email.com','Rua ABC, 1232, Centro','RS', false, 'Admin', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Masculino', 'Ativo', '(42) 11323-1321','funcionario', 'admin', NULL, 1);
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('veterinario', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'vet@email.com','Rua ABC, 1232, Centro','RS', false, 'Veterinaria', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Masculino', 'Ativo', '(42) 11323-1321','veterinario', 'veterinaria', '231344-23', 2);
INSERT INTO public.funcionario (atividade, cidade, cpf, data_cadastro, data_nascimento, email, endereco, estado, logado, nome, senha, sexo, status, telefone, tipo, usuario, crmv, permissao_id) VALUES('caixa', 'cidade', '214.154.314-13', '2021-10-01','2021-10-11', 'pet@email.com','Rua ABC, 1232, Centro','RS', false, 'Petshop', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Feminino', 'Ativo', '(42) 11323-1321','funcionario', 'petshop', NULL, 3);

-- Insert Clientes
INSERT INTO public.cliente (cidade,cpf,data_cadastro,data_nascimento,email,endereco,estado,nome,sexo,status,telefone) VALUES ('RSR','123.131.321-31','2021-10-20','2021-10-11','cliente1@email.com','RS, 2131, RS','RS','Cliente 1','Feminino','Ativo','(23) 21321-3131');

-- Trigger Audit
CREATE OR REPLACE FUNCTION INSERT_LOG() RETURNS trigger LANGUAGE plpgsql as $$ DECLARE v_old_data TEXT; v_new_data TEXT; BEGIN if (TG_OP = 'UPDATE') then v_old_data := ROW(OLD.*); v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, v_old_data, (select id from funcionario where logado = true)); RETURN NEW; elsif (TG_OP = 'DELETE') then v_old_data := ROW(OLD.*); insert into LOG (id, tabela, comando, data, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_old_data, (select id from funcionario where logado = true)); RETURN OLD; elsif (TG_OP = 'INSERT') then v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, (select id from funcionario where logado = true)); RETURN NEW; else RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now(); RETURN NULL; end if; END; $$

--Log usuário
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON AGENDA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON ATENDIMENTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON CAIXA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON CLIENTE FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON CONSULTA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON ESPECIE FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON FUNCIONARIO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PESO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PET FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PRODUTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON RACA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON SERVICO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON VENDA FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON VENDAPRODUTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();