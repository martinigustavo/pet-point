/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Especie;
import org.hibernate.SessionFactory;

public class EspecieDao extends AbstractGenericDao<Especie> {

    public EspecieDao(SessionFactory sessionFactory) {
        super(sessionFactory, Especie.class, "Especie");
    }
    
}
