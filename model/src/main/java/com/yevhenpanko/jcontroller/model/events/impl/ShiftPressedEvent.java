package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.SHIFT_PRESSED;

public class ShiftPressedEvent extends AbstractEvent {

    public ShiftPressedEvent(ComponentIdentifier source, float value) {
        super(source, SHIFT_PRESSED, value);
    }
}
