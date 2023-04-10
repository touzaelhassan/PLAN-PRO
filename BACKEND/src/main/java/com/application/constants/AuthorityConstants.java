package com.application.constants;

public class AuthorityConstants {
    public static final String[] ATTENDEE_AUTHORITIES = { "reservation:create", "reservation:read", "reservation:update", "reservation:delete"};
    public static final String[] ORGANIZER_AUTHORITIES = {"user:read", "event:create", "event:read", "event:update", "event:delete", "reservation:read", "reservation:update", "reservation:delete"};
    public static final String[] ADMIN_AUTHORITIES = {"user:create", "user:read", "user:update", "user:delete", "event:read", "event:update", "event:delete"};
}
