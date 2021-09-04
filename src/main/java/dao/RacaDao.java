/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Raca;
import org.hibernate.SessionFactory;

public class RacaDao extends AbstractGenericDao<Raca> {

    public RacaDao(SessionFactory sessionFactory) {
        super(sessionFactory, Raca.class, "Raca");
    }
    
}
