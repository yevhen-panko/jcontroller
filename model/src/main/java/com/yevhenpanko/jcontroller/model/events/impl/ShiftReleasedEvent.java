package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_PRESSED;
import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_RELEASED;

public class ShiftReleasedEvent implements Event {
    private final String name;

    public ShiftReleasedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return SHIFT_RELEASED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(false)
                .build();
    }
}
