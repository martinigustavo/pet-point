-- Insert Permissoes
INSERT INTO public.permissao (id, descricao) VALUES(default, 'admin');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'vet');
INSERT INTO public.permissao (id, descricao) VALUES(default, 'pet');

-- Insert Admin
insert into pessoa (pessoa_type,id,cidade,cpf,data_cadastro,data_nascimento,email,endereco,estado,nome,sexo,status,telefone,tipo,atividade,logado,senha,usuario,crmv, permissao_id) VALUES ('Funcionario', default,'Lajeado','214.154.314-13','2021-10-01','2021-10-11','admin@email.com','Rua ABC, 1232, Centro','RS','Admin','Masculino','Ativo','(42) 11323-1321','funcionario','Caixa',false,'e8d95a51f3af4a3b134bf6bb680a213a','admin',NULL, 1);

-- Trigger Audit
CREATE OR REPLACE FUNCTION INSERT_LOG() RETURNS trigger LANGUAGE plpgsql as $$ DECLARE v_old_data TEXT; v_new_data TEXT; BEGIN if (TG_OP = 'UPDATE') then v_old_data := ROW(OLD.*); v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, v_old_data, (select id from pessoa where logado = true)); RETURN NEW; elsif (TG_OP = 'DELETE') then v_old_data := ROW(OLD.*); insert into LOG (id, tabela, comando, data, valores_antigos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_old_data, (select id from pessoa where logado = true)); RETURN OLD; elsif (TG_OP = 'INSERT') then v_new_data := ROW(NEW.*); insert into LOG (id, tabela, comando, data, valores_novos, funcionario_id) values (DEFAULT, TG_TABLE_NAME::TEXT, current_query(), current_timestamp, v_new_data, (select id from pessoa where logado = true)); RETURN NEW; else RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now(); RETURN NULL; end if; END; $$

--Log usuário
CREATE trigger FUNCIONARIO_LOG AFTER INSERT OR UPDATE OR DELETE ON PRODUTO FOR EACH ROW EXECUTE PROCEDURE INSERT_LOG();