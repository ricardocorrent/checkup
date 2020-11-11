package com.checkup.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<File, UUID> {

    @Transactional
    @Query("SELECT i FROM File i WHERE i.topic.id =:fileId")
    List<File> findByTopicId(@Param("fileId") UUID fileId);
}
