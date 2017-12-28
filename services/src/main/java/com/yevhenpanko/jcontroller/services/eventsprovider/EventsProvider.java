package com.yevhenpanko.jcontroller.services.eventsprovider;

public interface EventsProvider {

    void register(Observer observer);

    void unregister(Observer observer);

    NotificationStatus getNotificationStatus();

    void startNotification();

    void pauseNotification();

    void stopNotifications();

    void notifyObservers();
}
