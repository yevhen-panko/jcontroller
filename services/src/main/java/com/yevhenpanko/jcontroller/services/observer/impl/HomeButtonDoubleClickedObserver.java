package com.yevhenpanko.jcontroller.services.observer.impl;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.identification.ComponentIdentifier;
import com.yevhenpanko.jcontroller.model.notification.NotificationStatus;
import com.yevhenpanko.jcontroller.services.eventsprovider.EventsProvider;

import static com.yevhenpanko.jcontroller.model.notification.NotificationStatus.*;

public class HomeButtonDoubleClickedObserver extends AbstractButtonDoubleClickedObserver {

    public HomeButtonDoubleClickedObserver(ApplicationConfig applicationConfig, EventsProvider eventsProvider) {
        super(applicationConfig, () -> {
            final NotificationStatus notificationStatus = eventsProvider.getNotificationStatus();
            if (notificationStatus == STARTED) {
                eventsProvider.pauseNotification();
            } else if (notificationStatus == PAUSED) {
                eventsProvider.startNotification();
            }
        });
    }

    @Override
    public EventDetails[] listenFor() {
        return new EventDetails[]{
                new EventDetails(ComponentIdentifier.HOME_BUTTON, EventType.BUTTON_PRESSED),
                new EventDetails(ComponentIdentifier.HOME_BUTTON, EventType.BUTTON_RELEASED)
        };
    }
}
