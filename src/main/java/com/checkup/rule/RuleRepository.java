package com.checkup.rule;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface RuleRepository extends PagingAndSortingRepository<Rule, UUID> {
}
