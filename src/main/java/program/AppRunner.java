
package program;

import utils.VisualsConfig;
import view.ApplicationView;
import view.LoginView;

public class AppRunner {

    public static void appRunner() {

        VisualsConfig.createLookAndFeel();
//        VisualsConfig.setAppFont();

        // Set swing frame visible after this comment
        // código que inicializa a aplicaçao (janela do login/cadastro)      
        new LoginView().setVisible(true);
//        new ApplicationView().setVisible(true);
                
        /*
        // testes de persistencia
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Funcionario Um");
        funcionario.setSexo("Masculino");
        funcionario.setCpf("123.456.789-19");
        funcionario.setTelefone("(51) 98765-4321");
        funcionario.setEmail("funcionario1@email.com");
        funcionario.setEndereco("Rua ABC, 175");
        funcionario.setCidade("Cidade");
        funcionario.setEstado("Estado");
        funcionario.setData_nascimento(LocalDate.of(1983, 12, 20));
        funcionario.setData_cadastro(LocalDate.now());
        funcionario.setStatus("ativo");
        funcionario.setUsuario("user");
        funcionario.setSenha("abcd1234");
        funcionario.setAtividade("atividade");

        // teste salvar
        FuncionarioDao fd = new FuncionarioDao(sessionFactory);
        Optional<Funcionario> funcOpt = fd.salvar(funcionario);
        if (funcOpt.isPresent()) {
            System.out.println("Funcionário salvo com sucesso!");
        } else {
            System.out.println("Funcionário não foi salvo");
        }
        /*
        // teste excluir registro
        int idTeste = 3;
        Optional<Funcionario> funcOpt2 = fd.buscar(idTeste);
        if (funcOpt2.isPresent()) {
            fd.excluir(funcOpt2.get());
            System.out.printf("------ FUNCIONÁRIO DE ID %d EXCLUÍDO!!! ------", idTeste);
        } else {
            System.out.println("Funcionário não encontrado!");
        }
        

        // teste buscar todos registros
        List<Funcionario> funcionariosCadastrados = fd.buscarTodos();
        funcionariosCadastrados.forEach(func -> {
            System.out.println("---------------------------------------");
            System.out.println("Funcionário_id = " + func.getId());
            System.out.println("Nome: " + func.getNome());
            System.out.println("CPF: " + func.getCpf());
            System.out.println("Cidade: " + func.getCidade());
            System.out.println("Email: " + func.getEmail());
            System.out.println("---------------------------------------");
        });
        */

    }
}
