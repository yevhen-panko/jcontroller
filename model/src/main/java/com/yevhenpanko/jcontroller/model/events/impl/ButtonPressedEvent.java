package com.yevhenpanko.jcontroller.model.events.impl;

import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import static com.yevhenpanko.jcontroller.model.events.EventType.BUTTON_PRESSED;

public class ButtonPressedEvent extends AbstractEvent {

    public ButtonPressedEvent(ComponentIdentifier source, float value) {
        super(source, BUTTON_PRESSED, value);
    }
}
