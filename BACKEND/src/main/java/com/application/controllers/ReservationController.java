package com.application.controllers;

import com.application.entities.Reservation;
import com.application.services.specifications.ReservationServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private final ReservationServiceSpecification reservationServiceBean;

    @Autowired
    public ReservationController(ReservationServiceSpecification reservationServiceBean) {
        this.reservationServiceBean = reservationServiceBean;
    }

    @PostMapping("/reservation/add")
    public ResponseEntity<Reservation> addReservation(
            @RequestParam("attendeeId") Integer attendeeId,
            @RequestParam("eventId") Integer eventId
    )  {

        Reservation reservation = reservationServiceBean.addReservation(attendeeId, eventId);

        return new ResponseEntity<>(reservation, OK);

    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationServiceBean.getReservations();
        return new ResponseEntity<>(reservations, OK);
    }
}
