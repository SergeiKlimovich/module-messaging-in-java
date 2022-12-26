package com.javaprogram.serializer;

import java.util.Map;
import java.util.Objects;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaprogram.entity.Event;

import lombok.SneakyThrows;

@Profile("kafka")
public class KafkaEventSerializer implements Serializer<Event> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    @SneakyThrows
    public byte[] serialize(String topic, Event data) {
        if (Objects.isNull(data)) {
            return new byte[0];
        }
        return objectMapper.writeValueAsBytes(data);
    }

    @Override
    public void close() {
    }

}
