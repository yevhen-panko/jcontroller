package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_PRESSED;
import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED;

public class StickMovedEvent implements Event {
    private final String name;
    private final float movingDistance;

    public StickMovedEvent(String name, float movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return STICK_MOVED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(true)
                .movingDistance(movingDistance)
                .build();
    }
}
