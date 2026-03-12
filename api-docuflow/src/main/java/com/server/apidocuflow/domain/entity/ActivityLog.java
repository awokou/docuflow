package com.server.apidocuflow.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "activity_logs")
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_activity_log_user_id"), nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id", foreignKey = @ForeignKey(name = "fk_activity_log_document_id"), nullable = false)
    private Document document;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
