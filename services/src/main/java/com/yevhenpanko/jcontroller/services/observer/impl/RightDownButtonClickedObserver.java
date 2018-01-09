package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import com.yevhenpanko.jcontroller.services.cursor.CursorShape;

import javax.swing.*;
import java.awt.*;

import static com.yevhenpanko.jcontroller.services.cursor.CursorShape.IBEAM;
import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

public class RightDownButtonClickedObserver extends AbstractMouseButtonClickedObserver {
    private com.yevhenpanko.jcontroller.services.cursor.Cursor cursor;
    private final JFrame component;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public RightDownButtonClickedObserver(JFrame component) throws AWTException {
        super(new Robot(), BUTTON1_DOWN_MASK);

        this.cursor = new com.yevhenpanko.jcontroller.services.cursor.Cursor();
        this.component = component;

        if (this.component != null) {
            final Rectangle bounds = component.getBounds();
            xMin = bounds.x;
            xMax = xMin + bounds.width;
            yMin = bounds.y;
            yMax = yMin + bounds.height;
        }
    }

    @Override
    public void updateState(Event... events) {
        final CursorShape currentCursor = cursor.getCurrentCursor();

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

                    if (component != null) {
                        if (currentCursor == IBEAM) {
                            if (!component.isVisible()) {
                                component.setVisible(true);
                            }
                        } else {
                            if (component.isVisible() && !cursorOnComponent()) {
                                component.setVisible(false);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public EventDetails[] listenFor() {
        return new EventDetails[]{
                new EventDetails(ComponentIdentifier.RIGHT_DOWN_BUTTON, EventType.BUTTON_PRESSED),
                new EventDetails(ComponentIdentifier.RIGHT_DOWN_BUTTON, EventType.BUTTON_RELEASED)
        };
    }

    private boolean cursorOnComponent(){
        if (component != null){
            final Point p = MouseInfo.getPointerInfo().getLocation();

            return p.x > xMin && p.x < xMax && p.y > yMin && p.y < yMax;
        }

        return false;
    }
}
