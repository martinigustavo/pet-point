/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClienteDao extends AbstractGenericDao<Cliente> {

    public ClienteDao(SessionFactory sessionFactory) {
        super(sessionFactory, Cliente.class, "Cliente");
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        List<Cliente> resultList = new LinkedList<>();

        try {
            Query<Cliente> query = session.createQuery("SELECT c FROM Cliente c WHERE lower(c.nome) LIKE lower(:nome) AND c.tipo = 'cliente'")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar clientes pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
    
}
