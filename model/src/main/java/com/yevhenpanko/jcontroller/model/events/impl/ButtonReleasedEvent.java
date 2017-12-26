package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.BUTTON_PRESSED;
import static com.yevhenpanko.jcontroller.model.events.EventType.BUTTON_RELEASED;

public class ButtonReleasedEvent implements Event {
    private final String name;

    public ButtonReleasedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return BUTTON_RELEASED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(false)
                .build();
    }
}
