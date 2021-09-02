/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entities.Usuario;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.VisualsConfig;

public class AppRunner {

    public static void appRunner() {
        // código que inicializa a aplicaçao
        //        Session session = HibernateUtil.getSessionFactory().openSession();
        //        try {
        //            Transaction tx = session.beginTransaction();
        //            
        //            Usuario usuario = new Usuario(Integer.SIZE, "Pessoa Teste 3", "pessoa3@email.com");
        //            
        //            session.save(usuario);
        //            tx.commit();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        } finally {
        //            session.close();
        //        }

        VisualsConfig.createLookAndFeel();
        VisualsConfig.setAppFont();
        
        // Set swing frame visible after this comment
//        new Test().setVisible(true);

    
    }

}
