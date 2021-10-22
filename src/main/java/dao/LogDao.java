/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Log;
import org.hibernate.SessionFactory;

/**
 *
 * @author Gustavo Martini
 */
public class LogDao extends AbstractGenericDao<Log> {
    
    public LogDao(SessionFactory sessionFactory) {
        super(sessionFactory, Log.class, "Log");
    }
}
