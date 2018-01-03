package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_RELEASED;

public class ShiftReleasedEvent extends AbstractEvent {

    public ShiftReleasedEvent(ComponentIdentifier source, float value) {
        super(source, SHIFT_RELEASED, value);
    }
}
