package com.yevhenpanko.jcontroller.services.eventsprovider;

import com.yevhenpanko.jcontroller.model.events.EventType;

import java.util.HashMap;
import java.util.Map;

import static com.yevhenpanko.jcontroller.services.eventsprovider.NotificationStatus.*;

public class JInputEventsProvider implements EventsProvider {
    private NotificationStatus notificationStatus = NOT_STARTED;
    private final Map<EventType[], Observer> observersMap;

    public JInputEventsProvider() {
        this.observersMap = new HashMap<>();
    }

    @Override
    public void register(Observer observer) {
        observersMap.put(observer.listenFor(), observer);
    }

    @Override
    public void unregister(Observer observer) {
        observersMap.remove(observer.listenFor());
    }

    @Override
    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    @Override
    public void startNotification() {
        notificationStatus = STARTED;
    }

    @Override
    public void pauseNotification() {
        notificationStatus = PAUSED;
    }

    @Override
    public void stopNotifications() {
        notificationStatus = STOPPED;
    }

    @Override
    public void notifyObservers() {

    }
}
