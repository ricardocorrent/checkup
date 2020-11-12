package com.checkup.rule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface RuleRepository extends PagingAndSortingRepository<Rule, UUID> {

    @Override
    @Query("select r from Rule r where r.cloned = false")
    Page<Rule> findAll(Pageable pageable);
}
