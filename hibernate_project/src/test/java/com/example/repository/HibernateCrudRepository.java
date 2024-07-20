package com.example.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class HibernateCrudRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {
    private final Class<T> entityType;
    private final SessionFactory sessionFactory;

    public HibernateCrudRepository(Class<T> entityType, SessionFactory sessionFactory) {
        this.entityType = entityType;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public T findById(ID id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(entityType, id);
        session.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        List<T> entities = session.createQuery("from " + entityType.getName(), entityType).list();
        session.close();
        return entities;
    }

    @Override
    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}