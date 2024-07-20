package com.example.repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
}
