package com.academy.app.service;

import java.util.List;

public interface CrudOperations<T> {
    T saveOrUpdate(T entity);
    T findById(Long id);
    void deleteById(Long id);
    List<T> findAll();
}
