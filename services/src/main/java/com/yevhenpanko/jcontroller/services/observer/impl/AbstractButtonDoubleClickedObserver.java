package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.services.observer.Observer;

public abstract class AbstractButtonDoubleClickedObserver implements Observer {
    private final ApplicationConfig applicationConfig;
    private final Runnable action;
    private boolean buttonPressed;
    private long firstClick;
    private int clicks;

    public AbstractButtonDoubleClickedObserver(ApplicationConfig applicationConfig, Runnable action) {
        this.applicationConfig = applicationConfig;
        this.action = action;
    }

    @Override
    public void updateState(Event... events) {
        for (Event event : events) {
            if (event.getType() == EventType.BUTTON_PRESSED) {
                if (!buttonPressed) {
                    buttonPressed = true;

                    if (clicks == 0){
                        firstClick = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - firstClick > applicationConfig.getDoubleClickDelay()){
                        firstClick = System.currentTimeMillis();
                        clicks = 0;
                    }

                    clicks++;

                    System.out.println(clicks);
                }
            } else {
                if (buttonPressed) {
                    buttonPressed = false;

                    if (clicks == 2){
                        clicks = 0;

                        action.run();
                    }
                }
            }
        }
    }
}
