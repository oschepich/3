package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

public abstract class ReadWriteDaoImpl<T> implements ReadWriteDao {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> tClass;
    @SuppressWarnings("unchecked")
    public ReadWriteDaoImpl() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void deleteByKeyCascadeIgnore(long id) {
        entityManager.createQuery("delete from " + tClass.getName() + " t where t.id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
