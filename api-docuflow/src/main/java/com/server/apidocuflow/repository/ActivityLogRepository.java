package com.server.apidocuflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.apidocuflow.domain.entity.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findByUserId(Long userId);
}