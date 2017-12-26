package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_PRESSED;

public class StickPressedEvent implements Event {
    private final String name;

    public StickPressedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return STICK_PRESSED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(true)
                .build();
    }
}
