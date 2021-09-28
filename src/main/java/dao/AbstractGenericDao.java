/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Log4j2
public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;
    private final String entityName;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public AbstractGenericDao(SessionFactory sessionFactory, Class<T> entityClass, String entityName) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
        this.entityName = entityName;
    }

    @Override
    public Optional<T> salvar(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(entity);
            transaction.commit();

            return Optional.of(entity);
        } catch (Exception e) {
            System.out.println("Erro ao salvar registro (" + entityName + "): " + e.getMessage());
            log.error("Erro ao salvar registro (" + entityName + "): " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }

    @Override
    public Optional<T> atualizar(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(entity);
            transaction.commit();

            return Optional.of(entity);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar registro (" + entityName + "): " + e.getMessage());
            log.error("Erro ao atualizar registro (" + entityName + "): " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }

    @Override
    public void excluir(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao excluir registro (" + entityName + "): " + e.getMessage());
            log.error("Erro ao excluir registro (" + entityName + "): " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<T> buscar(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            T entity = session.find(entityClass, id);
            transaction.commit();

            return Optional.of(entity);
        } catch (Exception e) {
            System.out.println("Erro ao buscar registro por id (" + entityName + "): " + e.getMessage());
            log.error("Erro ao buscar registro por id (" + entityName + "): " + e.getMessage());
        } finally {
            session.close();
        }

        return Optional.empty();
    }

    @Override
    public List<T> buscarTodos() {
        Session session = sessionFactory.openSession();
        List<T> resultList = new ArrayList<>();

        try {
            CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
            query.select(query.from(entityClass));
            resultList = session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos os registros (" + entityName + "): " + e.getMessage());
            log.error("Erro ao buscar todos os registros (" + entityName + "): " + e.getMessage());
        }
        return resultList;
    }

}
