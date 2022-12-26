package com.javaprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Event {
    private Long eventId;
    private String title;
    private String place;
    private String speaker;
    private EventType eventType;
    private LocalDateTime dateTime;

}
