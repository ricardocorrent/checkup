package com.checkup.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
