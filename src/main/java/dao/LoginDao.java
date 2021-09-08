/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Funcionario;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Gustavo Martini
 */
public class LoginDao {

    private final SessionFactory sessionFactory;

    public LoginDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Funcionario> buscarPorUsuario(String usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<Funcionario> query = session.createQuery("select p from Funcionario p where p.usuario = :user")
                    .setParameter("user", usuario);
            List<Funcionario> resultList = query.list();
            Optional<Funcionario> resultado = Optional.of(resultList.get(0));
            transaction.commit();

            return resultado;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Usuário não encontrado.");
        } finally {
            session.close();
        }

        return Optional.empty();
    }
}
