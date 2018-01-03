package com.yevhenpanko.jcontroller.services;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.Event;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.services.eventsprovider.EventsProvider;
import com.yevhenpanko.jcontroller.services.eventsprovider.JInputEventsProvider;
import com.yevhenpanko.jcontroller.services.observer.Observer;
import com.yevhenpanko.jcontroller.services.observer.impl.LeftStickMovedObserver;
import com.yevhenpanko.jcontroller.services.observer.impl.LeftStickRotatedObserver;
import net.java.games.input.Controller;

import java.awt.*;

import static net.java.games.input.Controller.*;

public class BackgroundApplication {

    public static void main(String[] args) throws AWTException {
        final ApplicationConfig applicationConfig = ApplicationConfig.getDefault();

        final EventsProvider eventsProvider = new JInputEventsProvider();
        eventsProvider.register(new LeftStickMovedObserver(applicationConfig));
        eventsProvider.register(new LeftStickRotatedObserver(applicationConfig));

        eventsProvider.notifyObservers();
    }
}
