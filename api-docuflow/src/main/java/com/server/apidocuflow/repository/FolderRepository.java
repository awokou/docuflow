package com.server.apidocuflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.apidocuflow.domain.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {

}
