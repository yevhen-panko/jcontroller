package com.yevhenpanko.jcontroller.services.eventsprovider;

import com.yevhenpanko.jcontroller.model.notification.NotificationStatus;
import com.yevhenpanko.jcontroller.services.observer.Observer;

public interface EventsProvider {

    void register(Observer observer);

    void unregister(Observer observer);

    NotificationStatus getNotificationStatus();

    void startNotification();

    void pauseNotification();

    void stopNotifications();

    void notifyObservers();
}
