/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import dao.FuncionarioDao;
import entities.Cliente;
import entities.Especie;
import entities.Funcionario;
import entities.Pet;
import entities.Raca;
import java.time.LocalDate;
import java.time.Month;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.VisualsConfig;

public class AppRunner {

    public static void appRunner() {

        VisualsConfig.createLookAndFeel();
        VisualsConfig.setAppFont();

        // Set swing frame visible after this comment
        // código que inicializa a aplicaçao (janela do login/cadastro)
//        new LoginFrame().setVisible(true);
        // testes de persistencia
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Transaction tx = session.beginTransaction();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Funcionario Um");
        funcionario.setSexo("Masculino");
        funcionario.setCpf("123.456.789-19");
        funcionario.setTelefone("(51) 98765-4321");
        funcionario.setEmail("funcionario1@email.com");
        funcionario.setEndereco("Rua ABC, 175");
        funcionario.setCidade("Lajeado");
        funcionario.setEstado("RS");
        funcionario.setData_nascimento(LocalDate.of(1983, 12, 20));
        funcionario.setData_cadastro(LocalDate.now());
        funcionario.setStatus("ativo");
        funcionario.setUsuario("user");
        funcionario.setSenha("abcd1234");
        funcionario.setAtividade("atividade");

        FuncionarioDao fd = new FuncionarioDao();
        fd.salvar(funcionario);

//            Cliente pedro = new Cliente();
//            pedro.setNome("Pedro Paulo");
//            pedro.setSexo("masculino");
//            pedro.setCpf("123.456.789-19");
//            pedro.setTelefone("(51) 98765-4321");
//            pedro.setEmail("pedro@email.com");
//            pedro.setEndereco("Rua AAAAA");
//            pedro.setCidade("Lajeado");
//            pedro.setEstado("RS");
//            pedro.setData_nascimento(LocalDate.of(1995, Month.MARCH, 3));
//            pedro.setData_cadastro(LocalDate.now());
//            pedro.setStatus("ativo");
//
//            session.save(pedro);
//
//            Especie gato = new Especie();
//            gato.setNome("Gato");
//
//            session.save(gato);
//
//            Raca persa = new Raca();
//            persa.setNome("Persa");
//            persa.setEspecie(gato);
//
//            session.save(persa);
//
//            Pet tonho = new Pet();
//            tonho.setNome("Tonho");
//            tonho.setSexo("Macho");
//            tonho.setEsterilizado(true);
//            tonho.setPorte("Pequeno");
//            tonho.setData_nascimento(LocalDate.of(2018, 5, 16));
//            tonho.setData_cadastro(LocalDate.now());
//            tonho.setCliente(pedro);
//            tonho.setRaca(persa);
//
//            session.save(tonho);
//
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }

}
