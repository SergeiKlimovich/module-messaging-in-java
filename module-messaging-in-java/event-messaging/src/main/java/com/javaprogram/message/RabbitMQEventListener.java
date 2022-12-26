package com.javaprogram.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.javaprogram.entity.Event;
import com.javaprogram.service.EventMessaging;
import com.javaprogram.service.EventService;

@Component
@Profile("rabbitmq")
public class RabbitMQEventListener{

    @Autowired
    private EventService eventService;

    @RabbitListener(queues = "create-event-request", messageConverter = "Jackson2JsonMessageConverter")
    public void createEvent(Event event) {
        eventService.createEventMessage(event);
    }

    @RabbitListener(queues = "update-event-request", messageConverter = "Jackson2JsonMessageConverter")
    public void updateEvent(Event event) {
        eventService.updateEventMessage(event.getEventId(), event);
    }

    @RabbitListener(queues = "delete-event-request", messageConverter = "Jackson2JsonMessageConverter")
    public void deleteEvent(Event event) {
        eventService.deleteEventMessage(event.getEventId());
    }
}
