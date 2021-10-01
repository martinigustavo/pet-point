/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Produto;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class ProdutoDao extends AbstractGenericDao<Produto> {

    public ProdutoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Produto.class, "Produto");
    }
    
    public List<Produto> buscarCustomizavel(String coluna, String info) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        List<Produto> resultList = new LinkedList<>();

        String customQuery = String.format("SELECT p FROM Produto p WHERE lower(p.%s) LIKE lower(:%s)", coluna, coluna);
        
        try {
            Query<Produto> query = session.createQuery(customQuery)
                    .setParameter(coluna, "%" + info + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar produtos pelo nome: " + e.getMessage());
            log.error("Erro ao buscar produtos pelo nome: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
    
}
