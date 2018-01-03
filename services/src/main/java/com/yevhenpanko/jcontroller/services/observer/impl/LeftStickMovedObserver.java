package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import com.yevhenpanko.jcontroller.services.observer.Observer;

import java.awt.*;

public class LeftStickMovedObserver implements Observer {
    private final ApplicationConfig applicationConfig;
    private final Robot robot;

    public LeftStickMovedObserver(ApplicationConfig applicationConfig) throws AWTException {
        this.applicationConfig = applicationConfig;
        this.robot = new Robot();
    }

    @Override
    public void updateState(Event... events) {
        for (Event event : events) {
            final Point p = MouseInfo.getPointerInfo().getLocation();
            int moveX = (int) (p.x + applicationConfig.getMouseMovingStepSize() * event.pollData());

            robot.mouseMove(moveX, p.y);
        }
    }

    @Override
    public EventDetails listenFor() {
        return new EventDetails(ComponentIdentifier.LEFT_STICK, EventType.STICK_MOVED);
    }
}
