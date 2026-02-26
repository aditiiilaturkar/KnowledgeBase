package com.ILearn.knowledgeBase.repository;

import com.ILearn.knowledgeBase.entity.DocumentChunk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentChunkRepository extends JpaRepository<DocumentChunk, Long> {
    List<DocumentChunk>  findByDocumentIdOrderByChunkIndexAsc(Long documentId);
}
