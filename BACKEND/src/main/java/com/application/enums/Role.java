package com.application.enums;

import static com.application.constants.AuthorityConstants.*;

public enum Role {
    ROLE_ATTENDEE(ATTENDEE_AUTHORITIES),
    ROLE_ORGANIZER(ORGANIZER_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES);
    private String[] authorities;
    Role(String... authorities){ this.authorities = authorities; }
    public String[] getAuthorities(){ return this.authorities; }
}
