package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_ROTATED;

public class StickRotatedEvent implements Event {
    private final String name;
    private final float rotationAngle;

    public StickRotatedEvent(String name, float rotationAngle) {
        this.name = name;
        this.rotationAngle = rotationAngle;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return STICK_ROTATED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(true)
                .rotationAngle(rotationAngle)
                .build();
    }
}
