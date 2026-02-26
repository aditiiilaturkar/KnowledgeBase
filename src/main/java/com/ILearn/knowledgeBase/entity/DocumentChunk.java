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
@Table(name = "document_chunks",
 indexes = {
        @Index(name="idx_chunks_document_id", columnList="document_id")
 })
@Entity
public class DocumentChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="document_id", nullable=false)
    private Document document;  // one doc can have many chunks

    @Column(nullable=false)
    private Integer chunkIndex;

    @Column(nullable=false, columnDefinition = "text")
    private String content;

    //  for citations
    private Integer pageStart;
    private Integer pageEnd;

    @Column(nullable=false)
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

}
