package com.ILearn.knowledgeBase.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "documents")
public class Document {

    public enum Status {
        UPLOADED, PROCESSING, READY, FAILED
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;  // one user can have many docs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 320)
    private String originalFileName;

    @Column(nullable=false, length=50)
    private String contentType; // "application/pdf", "text/plain"

    @Column(nullable=false)
    private Long fileSizeBytes;

    @Column(nullable=false, length=1000)
    private String storagePath;  // where we saved it on disk for now

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private Status status = Status.UPLOADED;

    @Column(nullable=false, updatable = false)
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }


}
