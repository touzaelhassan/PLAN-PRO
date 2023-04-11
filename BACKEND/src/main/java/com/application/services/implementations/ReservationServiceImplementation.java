package com.application.services.implementations;

import com.application.entities.Attendee;
import com.application.entities.Event;
import com.application.entities.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.services.specifications.EventServiceSpecification;
import com.application.services.specifications.ReservationServiceSpecification;
import com.application.services.specifications.UserServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImplementation implements ReservationServiceSpecification {

    private final UserServiceSpecification userServiceBean;
    private final EventServiceSpecification eventServiceBean;
    private final ReservationRepository reservationRepositoryBean;

    @Autowired
    public ReservationServiceImplementation(UserServiceSpecification userServiceBean, EventServiceSpecification eventServiceBean, ReservationRepository reservationRepositoryBean) {
        this.userServiceBean = userServiceBean;
        this.eventServiceBean = eventServiceBean;
        this.reservationRepositoryBean = reservationRepositoryBean;
    }

    @Override
    public Reservation addReservation(Integer attendeeId, Integer eventId) {
        Attendee attendee = (Attendee) userServiceBean.findUserById(attendeeId);
        Event event = eventServiceBean.getEventById(eventId);
        Reservation reservation = new Reservation();
        reservation.setAttendee(attendee);
        reservation.setEvent(event);
        reservation.setIsApproved(false);
        return reservationRepositoryBean.save(reservation);
    }

    @Override
    public List<Reservation> getReservations() { return reservationRepositoryBean.findAll(); }
}