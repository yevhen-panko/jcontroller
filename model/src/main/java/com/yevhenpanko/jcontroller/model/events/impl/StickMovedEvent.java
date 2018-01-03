package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED;

public class StickMovedEvent extends AbstractEvent {

    public StickMovedEvent(ComponentIdentifier source, float value) {
        super(source, STICK_MOVED, value);
    }
}
