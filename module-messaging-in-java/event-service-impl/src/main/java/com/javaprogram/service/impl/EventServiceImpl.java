package com.javaprogram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprogram.entity.Event;
import com.javaprogram.service.EventMessaging;
import com.javaprogram.service.EventService;
import com.javaprogram.service.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired(required = false)
    private EventMessaging eventMessaging;

    @Override
    public Event createEvent(Event event) {
        eventMessaging.createEvent(event);
        return event;
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        eventMessaging.updateEvent(event);
        return event;
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findEventById(id);
    }

    @Override
    public Event deleteEvent(Long id) {
        Event event = eventRepository.findEventById(id);
        eventMessaging.deleteEvent(event);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAllEvents();
    }

    @Override
    public void createEventMessage(Event event) {
        eventRepository.addEvent(event);
    }

    @Override
    public void updateEventMessage(Long id, Event event) {
        eventRepository.updateEventById(id, event);
    }

    @Override
    public void deleteEventMessage(Long id) {
        eventRepository.deleteEventById(id);
    }
}
