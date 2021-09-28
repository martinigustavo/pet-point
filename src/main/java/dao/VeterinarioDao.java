/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Veterinario;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class VeterinarioDao extends AbstractGenericDao<Veterinario> {

    public VeterinarioDao(SessionFactory sessionFactory) {
        super(sessionFactory, Veterinario.class, "Veterinario");
    }
    
    public List<Veterinario> buscarPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        List<Veterinario> resultList = new LinkedList<>();

        try {
            Query<Veterinario> query = session.createQuery("SELECT v FROM Veterinario v WHERE lower(v.nome) LIKE lower(:nome) AND v.tipo = 'veterinario'")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar veterinários pelo nome: " + e.getMessage());
            log.error("Erro ao buscar veterinários pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
}
