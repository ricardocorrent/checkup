package com.checkup.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentStoragePropertiesRepository extends JpaRepository<DocumentStorageProperties, UUID> {
    @Query("Select a from DocumentStorageProperties a where topic_id = ?1 and document_type = ?2")
    DocumentStorageProperties checkDocumentByTopicId(final UUID topicId, final String docType);

    @Query("Select fileName from DocumentStorageProperties a where topic_id = ?1 and document_type = ?2")
    String getUploadDocumentPath(final UUID topicId, final String docType);
}
