package com.server.apidocuflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.apidocuflow.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
