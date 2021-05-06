package com.amr.project.dao.abstracts;

import java.util.List;

public interface ReadWriteDao<T, K> {
    void persist(T t);

    void update(T t);

    void delete(T t);

    void deleteByKeyCascadeEnable(K id);

    void deleteByKeyCascadeIgnore(K id);

    boolean existsById(K id);

    T getByKey(K id);

    List<T> getAll();
}