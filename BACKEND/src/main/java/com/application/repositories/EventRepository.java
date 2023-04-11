package com.application.repositories;

import com.application.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepositoryBean")
public interface EventRepository extends JpaRepository<Event, Integer> { }
