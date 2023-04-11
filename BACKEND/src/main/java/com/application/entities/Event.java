package com.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private Integer places;
    private Date startDate;
    private Date endDate;
    private Boolean isAvailable;
    private Boolean isApproved;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Organizer organizer;
    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations = new ArrayList<>();

    public Event() { }

}
