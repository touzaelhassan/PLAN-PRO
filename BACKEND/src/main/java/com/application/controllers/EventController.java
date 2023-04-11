package com.application.controllers;

import com.application.classes.HttpResponse;
import com.application.entities.Category;
import com.application.entities.Event;
import com.application.services.specifications.EventServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventServiceSpecification eventServiceBean;

    @Autowired
    public EventController(EventServiceSpecification eventServiceBean) {
        this.eventServiceBean = eventServiceBean;
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getHotels() {
        List<Event> events = eventServiceBean.getEvents();
        return new ResponseEntity<>(events, OK);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }
}
