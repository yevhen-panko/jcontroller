package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED;
import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_RELEASED;

public class StickReleasedEvent implements Event {
    private final String name;

    public StickReleasedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return STICK_RELEASED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(false)
                .build();
    }
}
