package com.server.apidocuflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.apidocuflow.domain.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByUserId(Long userId);

    List<Document> findByNameContaining(String keyword);
}
