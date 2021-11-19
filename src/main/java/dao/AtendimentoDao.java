/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Atendimento;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class AtendimentoDao extends AbstractGenericDao<Atendimento> {

    public AtendimentoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Atendimento.class, "Atendimento");
    }
    
    public List<Atendimento> buscarPorIdDaAgenda(String id) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Atendimento> resultList = new LinkedList<>();

        try {
            Query<Atendimento> query = session.createQuery("SELECT a FROM Atendimento a JOIN agenda ag ON ag.id = a.agenda_id WHERE ag.id = :id")
                    .setParameter("id", id);
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar atendimentos pelo id da agenda: " + e.getMessage());
            log.error("Erro ao buscar atendimentos pelo id da agenda: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }
}
