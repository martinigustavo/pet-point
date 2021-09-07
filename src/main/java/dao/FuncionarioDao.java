/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Funcionario;
import java.util.Optional;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

public class FuncionarioDao extends AbstractGenericDao<Funcionario> {

    public FuncionarioDao(SessionFactory sessionFactory) {
        super(sessionFactory, Funcionario.class, "Funcionario");
    }
    // criar metodo para buscar por cpf cadastrado
    
}
