package com.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Organizer extends User{

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Event> events = new ArrayList<>();

    public Organizer() {}
    public Organizer(String userId, String firstname, String lastname, String username, String email, String password, String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, boolean isActive, boolean isNotLocked, String role, String[] authorities) {
        super(userId, firstname, lastname, username, email, password, profileImageUrl, lastLoginDate, lastLoginDateDisplay, joinDate, isActive, isNotLocked, role, authorities);
    }
    public Organizer(String userId, String firstname, String lastname, String username, String email, String password, String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, boolean isActive, boolean isNotLocked, String role, String[] authorities, List<Event> events) {
        super(userId, firstname, lastname, username, email, password, profileImageUrl, lastLoginDate, lastLoginDateDisplay, joinDate, isActive, isNotLocked, role, authorities);
        this.events = events;
    }
}
