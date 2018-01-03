package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED_HORIZONTALLY;
import static com.yevhenpanko.jcontroller.model.events.EventType.STICK_MOVED_VERTICALLY;

public class StickMovedVerticallyEvent extends AbstractEvent {

    public StickMovedVerticallyEvent(ComponentIdentifier source, float value) {
        super(source, STICK_MOVED_VERTICALLY, value);
    }
}
