package com.yevhenpanko.jcontroller.services;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.services.eventsprovider.EventsProvider;
import com.yevhenpanko.jcontroller.services.eventsprovider.JInputEventsProvider;
import com.yevhenpanko.jcontroller.services.observer.impl.*;

import java.awt.*;

public class BackgroundApplication {

    public static void main(String[] args) throws AWTException {
        final ApplicationConfig applicationConfig = ApplicationConfig.getDefault();

        final EventsProvider eventsProvider = new JInputEventsProvider();
        eventsProvider.register(new LeftStickMovedHorizontallyObserver(applicationConfig));
        eventsProvider.register(new LeftStickMovedVerticallyObserver(applicationConfig));
        eventsProvider.register(new RightStickMovedVerticallyObserver(applicationConfig));
        eventsProvider.register(new RightDownButtonClickedObserver());
        eventsProvider.register(new OptionsButtonClickedObserver());
        eventsProvider.register(new HomeButtonDoubleClickedObserver(applicationConfig, eventsProvider));

        eventsProvider.notifyObservers();
    }
}
