/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Agenda;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class AgendaDao extends AbstractGenericDao<Agenda> {

    public AgendaDao(SessionFactory sessionFactory) {
        super(sessionFactory, Agenda.class, "Agenda");
    }
    
    public List<Agenda> buscarPorPermissao(String permissao) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        List<Agenda> resultList = new LinkedList<>();
        
        try {
            Query<Agenda> query = session.createQuery("select a from Agenda a where a.funcionario.permissao.descricao = :permissao")
                    .setParameter("permissao", permissao);
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar agenda pela permissão do funcionário: " + e.getMessage());
            log.error("Erro ao buscar agenda pela permissão do funcionário: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
    
}
