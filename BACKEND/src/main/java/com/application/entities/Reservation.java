package com.application.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isApproved;

    @ManyToOne
    private Attendee attendee;
    @ManyToOne
    private Event event;

    public Reservation() { }

}
