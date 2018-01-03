package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_RELEASED;

public class StickReleasedEvent extends AbstractEvent {

    public StickReleasedEvent(ComponentIdentifier source, float value) {
        super(source, STICK_RELEASED, value);
    }
}
