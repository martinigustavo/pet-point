/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Venda;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Log4j2
public class VendaDao extends AbstractGenericDao<Venda> {

    public VendaDao(SessionFactory sessionFactory) {
        super(sessionFactory, Venda.class, "Venda");
    }
    
}
