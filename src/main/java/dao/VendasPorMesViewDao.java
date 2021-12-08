/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.VendasPorMesView;
import org.hibernate.SessionFactory;

/**
 *
 * @author gusta
 */
public class VendasPorMesViewDao extends AbstractGenericDao<VendasPorMesView> {

    public VendasPorMesViewDao(SessionFactory sessionFactory) {
        super(sessionFactory, VendasPorMesView.class, "VendasPorMesView");
    }
}
