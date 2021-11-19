/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.ReturningWork;

public class HibernateUtil {

    private static SessionFactory sf;
//    private static Session session = sf.openSession();

    public static SessionFactory getSessionFactory() {

        if (sf == null) {
            StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata md = new MetadataSources(sr).getMetadataBuilder().build();
            sf = md.getSessionFactoryBuilder().build();
        }

        return sf;
    }

//    public static Connection getJavaSqlConnectionFromHibernateSession() {
//
//        Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
//            @Override
//            public Connection execute(Connection conn) throws SQLException {
//                return conn;
//            }
//        });
//        return connection;
//    }

}
