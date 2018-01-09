package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.services.observer.Observer;

import java.awt.*;

public abstract class AbstractMouseButtonClickedObserver implements Observer {
    protected final Robot robot;
    protected final int buttonMask;
    protected boolean buttonPressed;

    public AbstractMouseButtonClickedObserver(Robot robot, int buttonMask) {
        this.robot = robot;
        this.buttonMask = buttonMask;
    }

    @Override
    public void updateState(Event... events) {
        for (Event event : events) {
            if (event.getType() == EventType.BUTTON_PRESSED) {
                if (!buttonPressed) {
                    buttonPressed = true;

                    robot.mousePress(buttonMask);
                }
            } else {
                if (buttonPressed) {
                    buttonPressed = false;

                    robot.mouseRelease(buttonMask);
                }
            }
        }
    }
}
