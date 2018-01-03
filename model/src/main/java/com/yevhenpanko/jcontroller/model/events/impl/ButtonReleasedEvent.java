package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.BUTTON_RELEASED;

public class ButtonReleasedEvent extends AbstractEvent {

    public ButtonReleasedEvent(ComponentIdentifier source, float value) {
        super(source, BUTTON_RELEASED, value);
    }
}
