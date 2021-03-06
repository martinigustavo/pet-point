/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Funcionario;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class FuncionarioDao extends AbstractGenericDao<Funcionario> {

    public FuncionarioDao(SessionFactory sessionFactory) {
        super(sessionFactory, Funcionario.class, "Funcionario");
    }

    public Optional<Funcionario> buscarPorUsuario(String usuario) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<Funcionario> query = session.createQuery("select p from Funcionario p where p.usuario = :user")
                    .setParameter("user", usuario);
            List<Funcionario> resultList = query.list();
            Optional<Funcionario> resultado = Optional.of(resultList.get(0));
            transaction.commit();

            return resultado;
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionário pelo usuário: " + e.getMessage());
            log.error("Erro ao buscar funcionário pelo usuário: " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }

    public List<Funcionario> buscarPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Funcionario> resultList = new LinkedList<>();

        try {
            Query<Funcionario> query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome) AND f.tipo = 'funcionario'")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionários pelo nome: " + e.getMessage());
            log.error("Erro ao buscar funcionários pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
    
    public List<Funcionario> buscarVetPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Funcionario> resultList = new LinkedList<>();

        try {
            Query<Funcionario> query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome) AND f.tipo = 'veterinario'")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionários pelo nome: " + e.getMessage());
            log.error("Erro ao buscar funcionários pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }

    public List<Funcionario> buscarPorNomeEPermissao(String nome, String permissao) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Funcionario> resultList = new LinkedList<>();

        try {
            Query<Funcionario> query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome)")
                    .setParameter("nome", "%" + nome + "%");

            if (permissao.equals("admin")) {
                query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome) AND f.permissao = 1")
                        .setParameter("nome", "%" + nome + "%");
            } else if (permissao.equals("vet")) {
                query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome) AND f.permissao = 2")
                        .setParameter("nome", "%" + nome + "%");
            } else if (permissao.equals("pet")) {
                query = session.createQuery("SELECT f FROM Funcionario f WHERE lower(f.nome) LIKE lower(:nome) AND f.permissao = 3")
                        .setParameter("nome", "%" + nome + "%");
            }

            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionários pelo nome: " + e.getMessage());
            log.error("Erro ao buscar funcionários pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }

    // criar metodo para buscar por cpf cadastrado
}
