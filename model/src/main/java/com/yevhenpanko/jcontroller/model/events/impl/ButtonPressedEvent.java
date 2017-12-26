package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;

import static com.yevhenpanko.jcontroller.model.events.EventType.*;

public class ButtonPressedEvent implements Event {
    private final String name;

    public ButtonPressedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return BUTTON_PRESSED;
    }

    public EventDetails getEventDetails() {
        return EventDetails
                .builder()
                .pressed(true)
                .build();
    }
}
