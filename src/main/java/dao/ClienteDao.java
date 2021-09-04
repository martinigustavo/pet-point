/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Cliente;
import org.hibernate.SessionFactory;

public class ClienteDao extends AbstractGenericDao<Cliente> {

    public ClienteDao(SessionFactory sessionFactory) {
        super(sessionFactory, Cliente.class, "Cliente");
    }
    
}
