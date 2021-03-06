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
}
