package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import com.yevhenpanko.jcontroller.services.observer.Observer;

import java.awt.*;

public class RightStickMovedVerticallyObserver implements Observer {
    private final ApplicationConfig applicationConfig;
    private final Robot robot;

    public RightStickMovedVerticallyObserver(ApplicationConfig applicationConfig) throws AWTException {
        this.applicationConfig = applicationConfig;
        this.robot = new Robot();
    }

    @Override
    public void updateState(Event... events) {
        for (Event event : events) {
            int wheelAmt = (int) (applicationConfig.getMouseScrollingStepSize() * event.pollData());

            robot.mouseWheel(wheelAmt);
        }
    }

    @Override
    public EventDetails[] listenFor() {
        return new EventDetails[]{new EventDetails(ComponentIdentifier.RIGHT_STICK, EventType.STICK_MOVED_VERTICALLY)};
    }
}
