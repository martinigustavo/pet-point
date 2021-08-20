/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entities.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class AppRunner {

    public static void appRunner() {

        // código que inicializa a aplicaçao
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            
            Usuario usuario = new Usuario(Integer.SIZE, "Pessoa Teste 3", "pessoa3@email.com");
            
            session.save(usuario);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
