package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED_HORIZONTALLY;

public class StickMovedHorizontallyEvent extends AbstractEvent {

    public StickMovedHorizontallyEvent(ComponentIdentifier source, float value) {
        super(source, STICK_MOVED_HORIZONTALLY, value);
    }
}
