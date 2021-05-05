package com.amr.project.dao.abstracts;

public interface ReadWriteDao {

    void deleteByKeyCascadeIgnore(long id);
}
