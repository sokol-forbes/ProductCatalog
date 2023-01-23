package com.academy.app.repository;

import com.academy.app.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepo<T extends BaseEntity> extends JpaRepository<T, Long> {
}
