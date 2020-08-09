package com.checkup.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface TopicRepository extends PagingAndSortingRepository<Topic, UUID> {
}
