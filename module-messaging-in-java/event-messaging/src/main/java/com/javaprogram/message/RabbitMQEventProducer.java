package com.javaprogram.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.javaprogram.entity.Event;
import com.javaprogram.service.EventMessaging;

@Component
@Profile("rabbitmq")
public class RabbitMQEventProducer implements EventMessaging {

    @Autowired
    private RabbitTemplate template;

    @Override
    public void createEvent(Event event) {
        template.convertAndSend("exchange-topic", "create-binding", event);
    }

    @Override
    public void updateEvent(Event event) {
        template.convertAndSend("exchange-topic", "update-binding", event);
    }

    @Override
    public void deleteEvent(Event event) {
        template.convertAndSend("exchange-topic", "delete-binding", event);
    }

}
