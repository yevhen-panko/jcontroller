package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.BUTTON_PRESSED;
import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_PRESSED;

public class ShiftPressedEvent implements Event {
    private final String name;
    private final float movingDistance;

    public ShiftPressedEvent(String name, float movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return SHIFT_PRESSED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(true)
                .movingDistance(movingDistance)
                .build();
    }
}
