/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;
    private final String entityName;

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
            e.printStackTrace();
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
            session.saveOrUpdate(entity);
            transaction.commit();

            return Optional.of(entity);
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            session.close();
        }

        return Optional.empty();
    }

    @Override
    public List<T> buscarTodos() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
        query.select(query.from(entityClass));
        return session.createQuery(query).getResultList();
    }

}
