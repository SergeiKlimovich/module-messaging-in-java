package com.javaprogram.service;

import com.javaprogram.entity.Event;

public interface EventMessaging {
    void createEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(Event event);
}
