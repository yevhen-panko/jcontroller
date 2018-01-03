package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_ROTATED;

public class StickRotatedEvent extends AbstractEvent {


    public StickRotatedEvent(ComponentIdentifier source, float value) {
        super(source, STICK_ROTATED, value);
    }
}
