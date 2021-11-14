/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Caixa;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;

@Log4j2
public class CaixaDao extends AbstractGenericDao<Caixa> {

    public CaixaDao(SessionFactory sessionFactory) {
        super(sessionFactory, Caixa.class, "Caixa");
    }
    
}
