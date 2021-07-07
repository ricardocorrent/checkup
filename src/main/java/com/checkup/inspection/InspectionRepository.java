package com.checkup.inspection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, UUID> {


    @Query("select i from Inspection i WHERE i.user.id =:userId order by i.draft desc")
    Page<Inspection> findAll(Pageable pageable, @Param("userId") UUID userId);

    @Query("select i from Inspection i WHERE i.user.id =:userId order by i.draft desc")
    List<Inspection> findAll(@Param("userId") UUID userId);
}
