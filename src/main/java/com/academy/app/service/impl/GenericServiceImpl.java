package com.academy.app.service.impl;

import com.academy.app.entity.BaseEntity;
import com.academy.app.exception.NotFoundException;
import com.academy.app.repository.BaseRepo;
import com.academy.app.service.CrudOperations;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class GenericServiceImpl<T extends BaseEntity> implements CrudOperations<T> {


    @NonNull
    protected BaseRepo<T> repository;

    @Override
    public T saveOrUpdate(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                String.format("Entity with id=%d not found", id)
        ));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll().stream()
                .filter(item -> !item.isDeleted())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        T entity = findById(id);
        if (entity.getId() != null) {
            repository.deleteById(id);
        }
    }
}