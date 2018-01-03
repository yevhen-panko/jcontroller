package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_PRESSED;

public class StickPressedEvent extends AbstractEvent {

    public StickPressedEvent(ComponentIdentifier source, float value) {
        super(source, STICK_PRESSED, value);
    }
}
