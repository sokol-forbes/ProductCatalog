package com.academy.app.dto.converter;

import java.util.ArrayList;
import java.util.List;


public interface EntityConverter<T,R> {
    R getDto(T entity);
    T getEntity(R dto);

    default List<R> getDtoList(List<T> entities) {
        List<R> list = new ArrayList<>();
        for (T entity : entities) {
            list.add(getDto(entity));
        }
        return list;
    }
}

