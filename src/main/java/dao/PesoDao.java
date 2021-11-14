/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Peso;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;

@Log4j2
public class PesoDao extends AbstractGenericDao<Peso> {

    public PesoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Peso.class, "Peso");
    }
    
}
