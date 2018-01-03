package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import java.awt.*;

import static java.awt.event.InputEvent.BUTTON3_DOWN_MASK;

public class OptionsButtonClickedObserver extends AbstractMouseButtonClickedObserver {

    public OptionsButtonClickedObserver() throws AWTException {
        super(new Robot(), BUTTON3_DOWN_MASK);
    }

    @Override
    public EventDetails[] listenFor() {
        return new EventDetails[]{
                new EventDetails(ComponentIdentifier.OPTIONS_BUTTON, EventType.BUTTON_PRESSED),
                new EventDetails(ComponentIdentifier.OPTIONS_BUTTON, EventType.BUTTON_RELEASED)
        };
    }
}
