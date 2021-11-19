/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Pet;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Log4j2
public class PetDao extends AbstractGenericDao<Pet> {

    public PetDao(SessionFactory sessionFactory) {
        super(sessionFactory, Pet.class, "Pet");
    }

    public List<Pet> buscarPorNome(String nome) {
        Session session = super.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Pet> resultList = new LinkedList<>();

        try {
            Query<Pet> query = session.createQuery("SELECT p FROM Pet p WHERE lower(p.nome) LIKE lower(:nome)")
                    .setParameter("nome", "%" + nome + "%");
            resultList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao buscar pet: " + e.getMessage());
            log.error("Erro ao buscar pet: " + e.getMessage());
        } finally {
            session.close();
        }

        return resultList;
    }

//    public List<Pet> buscarPorRaca(String nome) {
//        Session session = super.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<Pet> resultList = new LinkedList<>();
//
//        try {
//            Query<Pet> query = session.createQuery("SELECT p FROM Pet p LEFT JOIN raca r on p.raca_id = r.id WHERE lower(p.nome) LIKE lower(:nome)")
//                    .setParameter("nome", "%" + nome + "%");
//            resultList = query.list();
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Erro ao buscar pet: " + e.getMessage());
//            log.error("Erro ao buscar pet: " + e.getMessage());
//        } finally {
//            session.close();
//        }
//
//        return resultList;
//    }
//
//    public List<Pet> buscarPorDono(String nome) {
//        Session session = super.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<Pet> resultList = new LinkedList<>();
//
//        try {
//            Query<Pet> query = session.createQuery("SELECT p FROM Pet p WHERE lower(p.nome) LIKE lower(:nome)")
//                    .setParameter("nome", "%" + nome + "%");
//            resultList = query.list();
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Erro ao buscar pet: " + e.getMessage());
//            log.error("Erro ao buscar pet: " + e.getMessage());
//        } finally {
//            session.close();
//        }
//
//        return resultList;
//    }

}
