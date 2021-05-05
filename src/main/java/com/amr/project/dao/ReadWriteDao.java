package com.amr.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReadWriteDao<E> extends JpaRepository<E, Long> {

    void deleteByKeyCascadeEnable(long id);

    void deleteByKeyCascadeIgnore(long id);
}
