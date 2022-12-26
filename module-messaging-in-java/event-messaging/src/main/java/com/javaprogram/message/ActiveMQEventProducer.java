package com.javaprogram.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.javaprogram.entity.Event;
import com.javaprogram.service.EventMessaging;

@Component
@Profile("activemq")
public class ActiveMQEventProducer implements EventMessaging {

    @Autowired
    private JmsTemplate template;

    @Override
    public void createEvent(Event event) {
        template.convertAndSend("create-event-request", event);
    }

    @Override
    public void updateEvent(Event event) {
        template.convertAndSend("update-event-request", event);
    }

    @Override
    public void deleteEvent(Event event) {
        template.convertAndSend("delete-event-request", event);
    }
}