package com.checkup.topic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface TopicRepository extends PagingAndSortingRepository<Topic, UUID> {

    @Query("SELECT i FROM Topic i WHERE i.inspection.id =:inspectionId")
    List<Topic> findByInspectionId(@Param("inspectionId") UUID inspectionId);

    @Query("SELECT i FROM Topic i WHERE i.inspection.id =:inspectionId and i.item.id =:itemId")
    List<Topic> findByInspectionIdAndItemId(final UUID inspectionId, final UUID itemId);
}
