package com.yevhenpanko.jcontroller.services.eventsprovider;

import com.yevhenpanko.jcontroller.model.ApplicationConfig;
import com.yevhenpanko.jcontroller.model.events.EventType;
import com.yevhenpanko.jcontroller.model.notification.NotificationStatus;
import com.yevhenpanko.jcontroller.model.events.EventDetails;
import com.yevhenpanko.jcontroller.model.events.impl.StickMovedEvent;
import com.yevhenpanko.jcontroller.model.identification.IdentifierMapper;
import com.yevhenpanko.jcontroller.model.identification.PS4DualShockMapper;
import com.yevhenpanko.jcontroller.services.observer.Observer;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.HashMap;
import java.util.Map;

import static com.yevhenpanko.jcontroller.model.notification.NotificationStatus.*;
import static java.lang.Math.abs;

public class JInputEventsProvider implements EventsProvider {
    private final Map<EventDetails, Observer> observersMap;
    private final ApplicationConfig applicationConfig;
    private final IdentifierMapper identifierMapper;

    private NotificationStatus notificationStatus = NOT_STARTED;

    public JInputEventsProvider() {
        this.observersMap = new HashMap<>();
        this.applicationConfig = ApplicationConfig.getDefault();
        this.identifierMapper = new PS4DualShockMapper();
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
        final Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        final Controller controller = getController(controllers, Controller.Type.STICK);

        while (true) {
            controller.poll();

            for (Component component : controller.getComponents()) {
                final Component.Identifier identifier = component.getIdentifier();

                if (identifier == Component.Identifier.Axis.X) {
                    float value = component.getPollData();

                    if (abs(value) > applicationConfig.getTriggerOperatingThreshold()) {
                        for (EventDetails eventDetails : observersMap.keySet()) {
                            if (eventDetails.getSource() == identifierMapper.getIdentifier(identifier) && eventDetails.getType() == EventType.STICK_MOVED) {
                                final Observer observer = observersMap.get(eventDetails);
                                observer.updateState(new StickMovedEvent(eventDetails.getSource(), value));
                            }
                        }
                    }
                } else if (identifier == Component.Identifier.Axis.Y){
                    float value = component.getPollData();

                    if (abs(value) > applicationConfig.getTriggerOperatingThreshold()) {
                        for (EventDetails eventDetails : observersMap.keySet()) {
                            if (eventDetails.getSource() == identifierMapper.getIdentifier(identifier) && eventDetails.getType() == EventType.STICK_ROTATED) {
                                final Observer observer = observersMap.get(eventDetails);
                                observer.updateState(new StickMovedEvent(eventDetails.getSource(), value));
                            }
                        }
                    }
                }
            }

            try {
                Thread.sleep(applicationConfig.getInterrogationDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Controller getController(Controller[] controllers, Controller.Type type) {
        for (Controller controller : controllers) {
            if (controller.getType() == type) {
                return controller;
            }
        }

        throw new RuntimeException("Can't find STICK controller.");
    }
}
