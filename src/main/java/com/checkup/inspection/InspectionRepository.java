package com.checkup.inspection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, UUID> {

    @Override
    @Query("select i from Inspection i order by i.draft desc")
    Page<Inspection> findAll(Pageable pageable);

    @Override
    @Query("select i from Inspection i order by i.draft desc")
    List<Inspection> findAll();
}
