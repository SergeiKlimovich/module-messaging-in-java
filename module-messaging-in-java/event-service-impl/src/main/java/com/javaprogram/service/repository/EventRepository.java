package com.javaprogram.service.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaprogram.entity.Event;

@Repository
public class EventRepository {

    private final Map<Long, Event> events = new HashMap<>();

    public Event findEventById(Long id) {
        return events.get(id);
    }

    public List<Event> findAllEvents() {
        return new ArrayList<>(events.values());
    }

    public Event addEvent(Event event) {
        events.put(event.getEventId(), event);
        return event;
    }

    public Event updateEventById(Long id, Event event) {
        events.put(id, event);
        return event;
    }

    public Event deleteEventById(Long id) {
        Event event = events.get(id);
        events.remove(event.getEventId());
        return event;
    }
}
