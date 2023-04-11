package com.application.services.implementations;

import com.application.entities.Event;
import com.application.repositories.EventRepository;
import com.application.services.specifications.EventServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventServiceSpecification {
    private final EventRepository eventRepositoryBean;

    @Autowired
    public EventServiceImplementation(EventRepository eventRepositoryBean) {
        this.eventRepositoryBean = eventRepositoryBean;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepositoryBean.findAll();
    }

    @Override
    public Event getEventById(Integer id) { return eventRepositoryBean.findById(id).orElse(null); }
}
