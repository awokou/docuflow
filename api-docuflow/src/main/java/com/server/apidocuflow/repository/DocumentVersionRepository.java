package com.server.apidocuflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.apidocuflow.domain.entity.DocumentVersion;

public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long> {

    List<DocumentVersion> findByDocumentId(Long documentId);
}