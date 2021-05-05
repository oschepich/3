package com.amr.project.dao;

import java.util.Collections;

public abstract class AbstractReadWriteDao<T> implements ReadWriteDao<T> {

    @Override
    public void deleteByKeyCascadeEnable(long id) {
        deleteById(id);
    }

    @Override
    public void deleteByKeyCascadeIgnore(long id) {
        deleteInBatch(findAllById(Collections.singletonList(id)));
    }
}
