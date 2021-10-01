/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Produto;
import org.hibernate.SessionFactory;

public class ProdutoDao extends AbstractGenericDao<Produto> {

    public ProdutoDao(SessionFactory sessionFactory) {
        super(sessionFactory, Produto.class, "Produto");
    }
    
}
