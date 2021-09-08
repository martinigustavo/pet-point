/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Funcionario;
import org.hibernate.SessionFactory;

public class FuncionarioDao extends AbstractGenericDao<Funcionario> {

    public FuncionarioDao(SessionFactory sessionFactory) {
        super(sessionFactory, Funcionario.class, "Funcionario");
    }
    // criar metodo para buscar por cpf cadastrado
    
}
