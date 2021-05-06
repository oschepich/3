package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class ReadWriteDaoImpl<T, K> implements ReadWriteDao<T, K> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> tClass;

    @SuppressWarnings("unchecked")
    protected ReadWriteDaoImpl() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void deleteByKeyCascadeIgnore(K id) {
        entityManager.createQuery("delete from " + tClass.getName() + " t where t.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public void persist(T t) {
        entityManager.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

    @Override
    @Transactional
    public void deleteByKeyCascadeEnable(K id) {
        entityManager.remove(entityManager.find(tClass, id));
    }

    @Override
    public boolean existsById(K id) {
        return entityManager.find(tClass, id) != null;
    }

    @Override
    public T getByKey(K id) {
        return entityManager.find(tClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + tClass.getName()).getResultList();
    }
}
