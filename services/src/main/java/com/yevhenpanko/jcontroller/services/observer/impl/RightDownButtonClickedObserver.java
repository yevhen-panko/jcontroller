package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;

import java.awt.*;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

public class RightDownButtonClickedObserver extends AbstractMouseButtonClickedObserver {

    public RightDownButtonClickedObserver() throws AWTException {
        super(new Robot(), BUTTON1_DOWN_MASK);
    }

    @Override
    public EventDetails[] listenFor() {
        return new EventDetails[]{
                new EventDetails(ComponentIdentifier.RIGHT_DOWN_BUTTON, EventType.BUTTON_PRESSED),
                new EventDetails(ComponentIdentifier.RIGHT_DOWN_BUTTON, EventType.BUTTON_RELEASED),
        };
    }
}
