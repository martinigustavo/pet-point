/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Permissao;
import org.hibernate.SessionFactory;

public class PermissaoDao extends AbstractGenericDao<Permissao> {

    public PermissaoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Permissao.class, "Permissao");
    }

}
