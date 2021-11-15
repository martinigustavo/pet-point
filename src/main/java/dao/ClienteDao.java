/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;
import entities.Produto;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class ClienteDao extends AbstractGenericDao<Cliente> {

    public ClienteDao(SessionFactory sessionFactory) {
        super(sessionFactory, Cliente.class, "Cliente");
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        List<Cliente> resultList = new LinkedList<>();

        try {
            Query<Cliente> query = session.createQuery("SELECT c FROM Cliente c WHERE lower(c.nome) LIKE lower(:nome)")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar clientes pelo nome: " + e.getMessage());
            log.error("Erro ao buscar clientes pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
    
     public Optional<Cliente> buscarPorCpf(String cpf) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<Cliente> query = session.createQuery("select c from cliente c where p.cpf = :cpf")
                    .setParameter("cpf", cpf);
            List<Cliente> resultList = query.list();
            Optional<Cliente> resultado = Optional.of(resultList.get(0));
            transaction.commit();

            return resultado;
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente pelo cpf: " + e.getMessage());
            log.error("Erro ao buscar cliente pelo cpf: " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }
     
      public Optional<Cliente> getNome(int id) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<Cliente> query = session.createQuery("select c.nome from cliente c where p.id = :id")
                    .setParameter("id", id);
            List<Cliente> resultList = query.list();
            Optional<Cliente> resultado = Optional.of(resultList.get(0));
            transaction.commit();

            return resultado;
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente pelo nome: " + e.getMessage());
            log.error("Erro ao buscar cliente pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }
    
}
