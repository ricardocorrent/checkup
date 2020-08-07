package com.checkup.item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, UUID> {

    @Query("SELECT i FROM Item i WHERE i.rule.id =:ruleId")
    List<Item> findByRuleId(@Param("ruleId") UUID ruleId);
}
